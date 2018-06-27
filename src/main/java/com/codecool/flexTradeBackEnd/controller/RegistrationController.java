package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, String> data, HttpSession session){
        String newUserUserName = data.get("userName");
        String newUserEMail = data.get("email");
        String newUserPassword = data.get("password");
        registrationService.registerUser(newUserUserName, newUserEMail, newUserPassword,"User");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
