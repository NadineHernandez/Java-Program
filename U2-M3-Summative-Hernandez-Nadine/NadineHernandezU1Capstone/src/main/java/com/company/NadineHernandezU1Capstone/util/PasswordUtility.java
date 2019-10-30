package com.company.NadineHernandezU1Capstone.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "app_secret";
        //secret is: app_secret
        //passwords are: password!

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);

    }
}
