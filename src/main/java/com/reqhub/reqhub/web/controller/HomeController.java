package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
 public String home() {
	 return "/home";
 }
	@GetMapping("/atendente/home-atendente") // Rota igual ao redirect do SecurityConfig
	public String homeAdmin() {
	    return "atendente/home-atendente"; // Caminho RELATIVO sem barra inicial
	}
}
