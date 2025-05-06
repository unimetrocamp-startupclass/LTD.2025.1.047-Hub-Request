package com.reqhub.reqhub.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {

    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String senhaPlana = "admin123"; // Substitua pela senha desejada
        String senhaCriptografada = passwordEncoder.encode(senhaPlana);
        System.out.println("Senha criptografada (BCrypt): " + senhaCriptografada);
    }
}