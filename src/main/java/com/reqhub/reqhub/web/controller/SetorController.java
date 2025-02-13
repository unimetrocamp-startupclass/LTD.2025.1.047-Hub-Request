package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setores")
public class SetorController {

@GetMapping("/cadastrar") 
public String cadastrar() {
	return "setor/cadastro";
}

}
