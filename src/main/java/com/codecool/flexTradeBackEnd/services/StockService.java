package com.codecool.flexTradeBackEnd.services;

import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.StockRepository;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    UserRepository userRepository;

    private Map<String, String> stockCodeNameMap = new HashMap();

    public List<Stock> getAllStocks() {
        List<Stock> allStocks;
        allStocks = stockRepository.findAll();
        return allStocks;
    }

    public List<Stock> getAllStocksByUser(User user) {
        List<Stock> allStocksForUser;
        allStocksForUser = stockRepository.findAllByUsers(user);
        return allStocksForUser;
    }

    public Stock getStockByStockCode (String stockCode) {
        return stockRepository.findByStockCode(stockCode);
    }

    public void createNewStockEntry (String stockCode, String compName, Double workingCapitalRatio, Double earningsPerShare,
                                     Double priceEarningsRatio, Double debtEquityRatio, Double returnOnEquity) {
        Stock newStockEntry = new Stock (stockCode, compName, workingCapitalRatio, earningsPerShare,
                priceEarningsRatio, debtEquityRatio, returnOnEquity);
        stockRepository.save(newStockEntry);
    }

    public void addStockToUser (String stockCodeToAdd, String userName) {
        User targetUser = userRepository.findByUserName(userName);
        Stock targetStock = stockRepository.findByStockCode(stockCodeToAdd);
        targetUser.addStocks(targetStock);
        userRepository.save(targetUser);
    }

    public void removeStockFromUser (String stockCodeToRemove, String userName) {
        User targetUser = userRepository.findByUserName(userName);
        Set<Stock> userStocks = targetUser.getStocks();
        System.out.println(userStocks);
        for (Stock stock : userStocks) {
            if (Objects.equals(stock.getStockCode(), stockCodeToRemove)) {
                userStocks.remove(stock);
            }
        }
        System.out.println(userStocks);
        userRepository.save(targetUser);
        System.out.println(targetUser.getStocks());
    }

    public boolean checkForStockDataRefresh () {
        List <Stock> stockList = this.getAllStocks();
        /*for (Stock stock : stockList) {
            System.out.println(stock.getDateField());
        }*/
        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        Date currentDate = new Date();
//        System.out.println(myFormat.format(currentDate));
        String originalDate = "27 03 2018";
        try {
            Date date1 = myFormat.parse(originalDate);
            long diff = currentDate.getTime() - date1.getTime();
//            System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void refreshStockData () {

        stockCodeNameMap.put("AAPL", "Apple Inc.");
        stockCodeNameMap.put("GOOG","Google corp");
        stockCodeNameMap.put("MSFT", "Microsoft Corporation");
        stockCodeNameMap.put("EC", "Ecopetrol S.A.");
        stockCodeNameMap.put("XOM", "Exxon Mobil Corp.");
        stockCodeNameMap.put("RDS-B", "Royal Dutch Shell plc");
        stockCodeNameMap.put("CVX", "Chevron Corporation");
        stockCodeNameMap.put("JNJ", "Johnson & Johnson");
        stockCodeNameMap.put("PFE", "Pfizer Inc.");

        if (this.checkForStockDataRefresh()) {

            for (Map.Entry<String, String> entry : stockCodeNameMap.entrySet())
                {
                    String compCode = entry.getKey();
                    String compName = entry.getValue();
                    String applJson = this.getStockIndexData(entry.getKey(), entry.getValue());
                    Map jsonJavaRootObject = new Gson().fromJson(applJson, Map.class);
                    this.createNewStockEntry(compCode, compName,
                            (Double) jsonJavaRootObject.get("workingCapitalRatio"),
                            (Double) jsonJavaRootObject.get("earningsPerShare"),
                            (Double) jsonJavaRootObject.get("priceEarningsRatio"),
                            (Double) jsonJavaRootObject.get("debtEquityRatio"),
                            (Double) jsonJavaRootObject.get("returnOnEquity"));
                }
        }
    }

    public String getStockIndexData (String stockCompCode, String compName) {
        String stockInfo = "";
        try{
            URL url = new URL("http://127.0.0.1:5000/get-ratios/" + stockCompCode);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            int status = con.getResponseCode();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                stockInfo = content.toString();
            }
            con.disconnect();

        } catch (IOException e) {
            System.out.println(e);
        }
        return stockInfo;
    }

    public void stockInit () {
        this.addStockToUser("APPL", "Sanyi");
        this.addStockToUser("GOOG", "Sanyi");
        this.addStockToUser("PFE", "Sanyi");
        this.addStockToUser("CVX", "test1");
        this.addStockToUser("XOM", "test1");
    }
}
