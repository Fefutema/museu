package br.com.fatec.museu.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.fatec.museu.model.Obra;
import br.com.fatec.museu.repository.Exposicoes;
import br.com.fatec.museu.repository.Obras;
import javassist.NotFoundException;

@Controller
@RequestMapping("/acervo")
public class AcervoController {

	@Autowired
	private Obras obras;
	
	@Autowired
	private Exposicoes exposicoes;
	
	@GetMapping("/obras")
	public ModelAndView listarObras() {
		
		ModelAndView modelAndView = new ModelAndView("listaObras");
		
		modelAndView.addObject("obras", obras.findAll());
		
		return modelAndView;
	}
	
	@GetMapping("/curador/buscar-obra")
	public ModelAndView buscarObras() {
		
		ModelAndView modelAndView = new ModelAndView("buscarObras");
		
		modelAndView.addObject("obras", new ArrayList<>());
		
		return modelAndView;
	}
	
	@PostMapping("/curador/buscar-obra")
	public ModelAndView buscarObras(@RequestParam String obra) {
		
		ModelAndView modelAndView = new ModelAndView("buscarObras");
		
		modelAndView.addObject("obras", this.obras.findByAutorOrName(obra));
		
		return modelAndView;
	}
	
	@GetMapping("/curador/cadastrar-obra")
	public ModelAndView toCadastro() {
		
		ModelAndView modelAndView = new ModelAndView("cadastrarObra");
		
		modelAndView.addObject(new Obra());
		modelAndView.addObject("exposicoes", this.exposicoes.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("/curador/efetivarCadastro")
	public String cadastrarObra(Obra obra) {
		if(obra != null) {
			this.obras.save(obra);
		}
		
		return "redirect:/acervo/obras";
	}
	
	@GetMapping("/curador/editar-obra/{id}")
	public ModelAndView editarObra(@PathVariable Long id) throws NotFoundException {
		ModelAndView modelAndView = new ModelAndView("editarObra");
		
		Optional<Obra> obra = this.obras.findById(id);
		
		if(obra.get() == null) {
			throw new NotFoundException("Nenhuma obra encontrada com esse Id");
		}
		
		modelAndView.addObject(obra.get());
		modelAndView.addObject("exposicoes", this.exposicoes.findAll());
		
		return modelAndView;
	}
	
	@PostMapping("/curador/excluir-obra/{id}")
	public String excluirObra(@PathVariable Long id) throws Exception {
		
		if(id != null) {
			this.obras.deleteById(id);			
		}else {
			throw new Exception("Nenhum registro encontrado para o id = " + id);
		}
		
		return "redirect:/acervo/obras";
	}
	
}
