package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/setor")
public class SetorController {

	@GetMapping("/cadastrar")
	public String cadastro() {
		return "/setor/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar() {
		return "/setor/lista";
	}
}
