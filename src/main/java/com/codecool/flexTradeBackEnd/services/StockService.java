package com.codecool.flexTradeBackEnd.services;

import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.StockRepository;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    UserRepository userRepository;

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

    public void createNewStockEntry (String stockCode, String compName, Float workingCapitalRatio, Float earningsPerShare,
                                     Float priceEarningsRatio, Float debtEquityRatio, Float returnOnEquity) {
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
}
