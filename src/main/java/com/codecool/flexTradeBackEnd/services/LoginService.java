package com.codecool.flexTradeBackEnd.services;

import com.codecool.flexTradeBackEnd.Utils.PasswordHashed;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    PasswordHashed bcrypt = new PasswordHashed();

    @Autowired
    UserRepository userRepository;

    public Map<String, String> loginUser(String userName, String password) {
        HashMap checkedUserMap;
        String hahsedPassword = bcrypt.passwordHasher(password);
        if (bcrypt.passwordVerifier(password, hahsedPassword)) {
            try {
                User current = userRepository.findByUserName(userName);
                checkedUserMap = new HashMap();
                checkedUserMap.put("userName", current.getUserName());
                return checkedUserMap;
            } catch (NullPointerException e) {
                System.out.println("Server error occurred when looking up User");
                return null;
            }

        } else {
            return null;
        }
    }
}
