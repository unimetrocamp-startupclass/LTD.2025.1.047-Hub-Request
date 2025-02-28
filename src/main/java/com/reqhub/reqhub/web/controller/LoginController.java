package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/logins")
	public String login() {
		return"auth/login";
	}
}
