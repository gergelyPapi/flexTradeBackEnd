package com.codecool.flexTradeBackEnd.Utils;


import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashed {
    // Hash a password for the first time

    public String passwordHasher (String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public Boolean passwordVerifier (String candidate, String hashed) {
        if (BCrypt.checkpw(candidate, hashed))
            return true;
        else
            return false;
    }

}
