package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import pe.edu.upc.spring.model.Departamento;
import pe.edu.upc.spring.model.Provincia;

import pe.edu.upc.spring.service.IDepartamentoService;
import pe.edu.upc.spring.service.IProvinciaService;

@Controller
@RequestMapping("/provincia")
public class ProvinciaController {
	
	@Autowired
	private IDepartamentoService dService;
	
	@Autowired
	private IProvinciaService pService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoProvincias(Map<String, Object> model) {
		model.put("listaProvincias", pService.listar());
		return "listProvincia";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroProvincias(Model model) {
		
		model.addAttribute("listaDepartamentos", dService.listar());
		
		model.addAttribute("provincia", new Provincia());
		model.addAttribute("departamento", new Departamento());
		
		return "provincia";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Provincia objProvincia, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaDepartamentos", dService.listar());
			return "provincia";
		}
		else {
			boolean flag = pService.insertar(objProvincia);
			if (flag)
				return "redirect:/provincia/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/provincia/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Provincia> objProvincia = pService.listarId(id);
		if (objProvincia == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/provincia/listar";
		}
		else {
			model.addAttribute("listaDepartamento", dService.listar());
			
			if(objProvincia.isPresent())
				objProvincia.ifPresent(o -> model.addAttribute("provincia", o));
			
			return "provincia";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				pService.eliminar(id);
				model.put("listaProvincias", pService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaProvincias", pService.listar());
		}
		return "listProvincia";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaProvincias", pService.listar());
		return "listProvincia";
	}
	
}
