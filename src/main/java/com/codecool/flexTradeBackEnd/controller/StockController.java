package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.Company;
import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.services.CompanyService;
import com.codecool.flexTradeBackEnd.services.StockService;
import com.codecool.flexTradeBackEnd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    UserService userService;

    @Autowired
    CompanyService companyService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/get-all-stocks", method = RequestMethod.GET)
    public ResponseEntity<List<Stock>> getAllStocks(){
        List<Stock> allStock;
        allStock = stockService.getAllStocks();
        if (allStock == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allStock, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/get-all-stock-by-user/{userName}", method = RequestMethod.GET)
    public ResponseEntity<List<Stock>> getAllStocksByUser(@PathVariable String userName){
        List<Stock> allStockByUser;
        User user = userService.getUserByUserName(userName);
        allStockByUser = stockService.getAllStocksByUser(user);
        System.out.println(allStockByUser);
        if (allStockByUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allStockByUser, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/add-stock-to-user/{user_name}/{stock_comp_code}", method = RequestMethod.GET)
    public ResponseEntity<String> addStockToUser(@PathVariable String user_name,
                                                    @PathVariable String stock_comp_code) {
        Company targetCompany = companyService.findByStockCode(stock_comp_code);
        System.out.println("User requested stock to follow: " + user_name);
        String stock_comp_name = targetCompany.getCompName();
        System.out.println("Stock company name requested to be followed: " + stock_comp_name);
        System.out.println("Stock company code requested to be followed: " + stock_comp_code);

        stockService.getStockIndexData(stock_comp_code, stock_comp_name);

        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
