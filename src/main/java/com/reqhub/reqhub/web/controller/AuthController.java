package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("auths")
public class AuthController {

	@GetMapping("/login")
	public String showLoginPage() {
		return "auth/login";
	}
	
	@GetMapping("cadastrar")
	public String cadastrar() {
		return "auth/cadastrar";
	}
}
