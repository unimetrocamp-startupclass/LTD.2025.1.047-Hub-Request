package com.reqhub.reqhub.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ordens")
public class OrdemController {
	
	@GetMapping("/comentario")
	public String comentario() {
		return "ordem/comentario";
	}
	
	@GetMapping("/buscar")
	public String buscar() {
		return "ordem/buscar";
	}
}
