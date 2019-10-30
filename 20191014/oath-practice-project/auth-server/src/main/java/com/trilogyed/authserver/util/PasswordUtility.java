package com.trilogyed.authserver.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtility {

    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "pwdPWDpwd!";

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);

    }
}
