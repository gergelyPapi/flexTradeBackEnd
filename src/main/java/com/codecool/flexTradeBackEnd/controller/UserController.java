package com.codecool.flexTradeBackEnd.controller;

import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") int id, HttpSession session){
        User currentUser;
        currentUser = userService.getUserById(id);
        if (currentUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(currentUser, HttpStatus.OK);
        }
    }

    @CrossOrigin("http://localhost:3000")
    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    public ResponseEntity<String> deleteUser(@RequestBody Map<String, String> data, HttpSession session){
        String currentUserName = data.get("userName");
        User foundUser = userService.getUserByUserName(currentUserName);
        userService.deleteUser(foundUser);
        if (foundUser == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("User Deleted", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/user/all", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUser(HttpSession session){
        List<User> allUsers;
        allUsers = userService.getAllUser();
        if (allUsers == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(allUsers, HttpStatus.OK);
        }
    }
}
