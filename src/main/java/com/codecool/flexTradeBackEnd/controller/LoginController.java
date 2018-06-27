package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> verifyUser(@RequestBody Map<String, String> data){
        String userInputUserName = data.get("userName");
        String userInputPassword = data.get("password");
        Map checkedUserMap = loginService.loginUser(userInputUserName, userInputPassword);
        if ( checkedUserMap != null) {
            return new ResponseEntity<>(checkedUserMap, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(checkedUserMap, HttpStatus.BAD_REQUEST);
        }
    }
}
