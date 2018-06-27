package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.Stock;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.services.StockService;
import com.codecool.flexTradeBackEnd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    UserService userService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/stocks", method = RequestMethod.GET)
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
    @RequestMapping(value = "/stock/{userName}", method = RequestMethod.GET)
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
    @RequestMapping(value = "/addStock/{user_name}/{stock_code_name}", method = RequestMethod.GET)
    public ResponseEntity<String> addStockToUser(@PathVariable String user_name, @PathVariable String stock_code_name){
        System.out.println("User requested stock to follow: " + user_name);
        System.out.println("Stock nameCode requested to be followed: " + stock_code_name);
//        stockService.addStockToUser(stock_code_name, user_name);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
