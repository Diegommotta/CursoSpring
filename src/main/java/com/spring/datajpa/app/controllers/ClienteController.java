package com.spring.datajpa.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.datajpa.app.models.Service.IClienteService;
import com.spring.datajpa.app.models.dao.IClienteDao;
import com.spring.datajpa.app.models.entity.Cliente;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clientservice;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "listado de clientes");
		model.addAttribute("clientes", clientservice.findAll());

		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {

		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "formulario cliente ");
		return "form";
	}

	@RequestMapping (value="/form", method = RequestMethod.POST)
	public String guardar (@Valid Cliente cliente ,BindingResult result , Model model) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "formulario cliente");
			return "form";
		}
		
		clientservice.save(cliente);
		return "redirect:listar";
	}
	
	
	@RequestMapping (value="/form/{id}")
	public String editar (@PathVariable(value="id") Long id , Map <String, Object> model) {
		
		Cliente cliente=null;
		
		if (id>0) {
			
			cliente= clientservice.findOne(id);
		}
		else {
		
			return "redirect:listar";
			
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "editar cliente");
		return "form";
		
	}
	
	
	@RequestMapping (value="/eliminar/{id}")
	 public String eliminar (@PathVariable(value="id") Long id) {
		
		if (id > 0 ) {
			
			clientservice.delete(id);
		}
		
		return "redirect:/listar";
	}
	
}
