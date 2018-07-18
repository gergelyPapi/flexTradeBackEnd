package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.Company;
import com.codecool.flexTradeBackEnd.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/get-all-stock-options", method = RequestMethod.GET)
    public ResponseEntity<List<Company>> getAllStockOptions(HttpSession session){
        List<Company> allStockOptions;
        allStockOptions = companyService.getAllCompanies();
        if (allStockOptions == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allStockOptions, HttpStatus.OK);
        }
    }
}
