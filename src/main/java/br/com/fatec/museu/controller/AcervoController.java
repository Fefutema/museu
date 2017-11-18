package br.com.fatec.museu.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.museu.model.Obra;
import br.com.fatec.museu.repository.Obras;

@Controller
@RequestMapping("/acervo")
public class AcervoController {

	@Autowired
	private Obras obras;
	
	@GetMapping("/obras")
	public ModelAndView listarObras() {
		
		ModelAndView modelAndView = new ModelAndView("listaObras");
		
		modelAndView.addObject("obras", obras.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/cadastrar-obra")
	public ModelAndView toCadastro() {
		
		ModelAndView modelAndView = new ModelAndView("cadastrarObra");
		
		modelAndView.addObject(new Obra());
		
		return modelAndView;
	}
	
	@PostMapping("/efetivarCadastro")
	public String cadastrarObra(Obra obra) {
		if(obra != null) {
			this.obras.save(obra);
		}
		
		return "redirect:/acervo/obras";
	}
	
}
