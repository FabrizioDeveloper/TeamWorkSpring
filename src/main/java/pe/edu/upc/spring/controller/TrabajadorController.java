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


import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.model.Trabajador;

import pe.edu.upc.spring.service.IUsuarioService;
import pe.edu.upc.spring.service.ITrabajadorService;

@Controller
@RequestMapping("/trabajador")
public class TrabajadorController {
	
	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private ITrabajadorService tService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoTrabajadores(Map<String, Object> model) {
		model.put("listaTrabajadores", tService.listar());
		return "listTrabajador";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroTrabajadores(Model model) {
		
		model.addAttribute("listaUsuarios", uService.listar());
		
		model.addAttribute("trabajador", new Trabajador());
		model.addAttribute("usuario", new Usuario());
		
		return "trabajador";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Trabajador objTrabajador, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaUsuarios", uService.listar());
			return "trabajador";
		}
		else {
			boolean flag = tService.insertar(objTrabajador);
			if (flag)
				return "redirect:/trabajador/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/trabajador/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Trabajador> objTrabajador = tService.listarId(id);
		if (objTrabajador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/trabajador/listar";
		}
		else {
			model.addAttribute("listaUsuario", uService.listar());
			
			if(objTrabajador.isPresent())
				objTrabajador.ifPresent(o -> model.addAttribute("trabajador", o));
			
			return "trabajador";
		}
	}

	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				tService.eliminar(id);
				model.put("listaTrabajadores", tService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTrabajadores", tService.listar());
		}
		return "listTrabajador";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTrabajadores", tService.listar());
		return "listTrabajador";
	}
	
	@RequestMapping("/irBuscar")
	public String buscar(Model model) { 
		model.addAttribute("trabajdor", new Trabajador());
		return "buscar";
	}
}
