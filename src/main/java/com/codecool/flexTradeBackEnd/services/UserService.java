package com.codecool.flexTradeBackEnd.services;

import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById (Integer id) {
        User userToFind;
        try {
            userToFind = userRepository.findById(id);
            return userToFind;
        } catch (NullPointerException e) {
            System.out.println("User with that id was not found!");
        }
        return null;
    }

    public User getUserByUserName (String userName) {
        User userToFind;
        try {
            userToFind = userRepository.findByUserName(userName);
            return userToFind;
        } catch (NullPointerException e) {
            System.out.println("User with that id was not found!");
        }
        return null;
    }

    public void deleteUser(User foundUser) {
        userRepository.delete(foundUser);
    }

    public List<User> getAllUser() {
        List<User> allUsers = null;
        System.out.println(allUsers.toString());
        allUsers = userRepository.findAll();
        return allUsers;
    }

}
