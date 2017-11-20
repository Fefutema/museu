package br.com.fatec.museu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

	@GetMapping("/index")
	public String toHome() {
		
		return "index";
	}
	
	
}
