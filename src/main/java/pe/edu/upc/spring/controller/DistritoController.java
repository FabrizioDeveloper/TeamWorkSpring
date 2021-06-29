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


import pe.edu.upc.spring.model.Provincia;
import pe.edu.upc.spring.model.Distrito;

import pe.edu.upc.spring.service.IProvinciaService;
import pe.edu.upc.spring.service.IDistritoService;

@Controller
@RequestMapping("/distrito")
public class DistritoController {
	
	@Autowired
	private IProvinciaService pService;
	
	@Autowired
	private IDistritoService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoDistritos(Map<String, Object> model) {
		model.put("listaDistritos", dService.listar());
		return "listDistrito";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroDistritos(Model model) {
		
		model.addAttribute("listaProvincias", pService.listar());
		
		model.addAttribute("distrito", new Distrito());
		model.addAttribute("provincia", new Provincia());
		
		return "distrito";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Distrito objDistrito, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaProvincias", pService.listar());
			return "distrito";
		}
		else {
			boolean flag = dService.insertar(objDistrito);
			if (flag)
				return "redirect:/distrito/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/distrito/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Distrito> objDistrito = dService.listarId(id);
		if (objDistrito== null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/distrito/listar";
		}
		else {
			model.addAttribute("listaProvincia", pService.listar());
			
			if(objDistrito.isPresent())
				objDistrito.ifPresent(o -> model.addAttribute("distrito", o));
			
			return "distrito";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				dService.eliminar(id);
				model.put("listaDistritos", dService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDistritos", dService.listar());
		}
		return "listDistrito";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaDistritos", dService.listar());
		return "listDistrito";
	}
	
}
