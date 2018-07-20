package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.services.CompanyService;
import com.codecool.flexTradeBackEnd.services.StockService;
import com.codecool.flexTradeBackEnd.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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
    public ResponseEntity<Set<Stock>> getAllStocksByUser(@PathVariable String userName){
        Set<Stock> allStockByUser = userService.getUserByUserName(userName).getStocks();
        if (allStockByUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allStockByUser, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/get-stock-by-comp-code/{comp_code}", method = RequestMethod.GET)
    public ResponseEntity<Stock> getStockByCompCode(@PathVariable String comp_code){
        Stock targetStock;
        try {
            targetStock = stockService.getStockByStockCode(comp_code);
            return new ResponseEntity<>(targetStock, HttpStatus.OK);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/add-stock-to-user/{user_name}/{stock_comp_code}", method = RequestMethod.GET)
    public ResponseEntity<String> addStockToUser(@PathVariable String user_name,
                                                    @PathVariable String stock_comp_code) {
        User requestUser = userService.getUserByUserName(user_name);
        stockService.addStockToUser(stock_comp_code,user_name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/remove-stock-from-user/{user_name}/{stock_comp_code}", method = RequestMethod.GET)
    public ResponseEntity<String> removeStockFromUser(@PathVariable String user_name,
                                                 @PathVariable String stock_comp_code) {
        stockService.removeStockFromUser(stock_comp_code,user_name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
