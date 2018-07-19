package com.codecool.flexTradeBackEnd.services;


import com.codecool.flexTradeBackEnd.Utils.PasswordHashed;
import com.codecool.flexTradeBackEnd.models.User;
import com.codecool.flexTradeBackEnd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private StockService stockService;

    PasswordHashed bcrypt = new PasswordHashed();

    public void registerUser (String userName, String email, String password, String authority) {
        String passwordHash = bcrypt.passwordHasher(password);
        User newUser = new User (userName, email, passwordHash, authority);
        userRepository.save(newUser);
    }

    public void registrationInit () {
            if (userService.getAllUser().size() <= 0 || userService.getAllUser() == null) {
                this.registerUser("test1", "test1@gmail.com","123", "Admin");
                this.registerUser("test2", "test2@gmail.com","1234", "User");
                this.registerUser("Sanyi", "test3@gmail.com","12345", "User");

            }

            /*User sanyi = userService.getUserByUserName("Sanyi");
            System.out.println(sanyi.getStocks());*/
    }
}
