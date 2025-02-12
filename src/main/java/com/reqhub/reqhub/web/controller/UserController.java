package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/cadastro")
    public String mostrarCadastro() {
        return "user/cadastro"; // Caminho correto para templates Thymeleaf
    }
}


