package com.codecool.flexTradeBackEnd.services;


import com.codecool.flexTradeBackEnd.Utils.PasswordHashed;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    UserRepository userRepository;

    PasswordHashed bcrypt = new PasswordHashed();

    public void registerUser (String userName, String email, String password, String authority) {
        String passwordHash = bcrypt.passwordHasher(password);
        User newUser = new User (userName, email, passwordHash, authority);
        userRepository.save(newUser);
    }
}
