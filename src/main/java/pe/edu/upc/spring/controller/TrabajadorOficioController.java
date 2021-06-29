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

import pe.edu.upc.spring.model.Oficio;
import pe.edu.upc.spring.model.Trabajador;
import pe.edu.upc.spring.model.TrabajadorOficio;

import pe.edu.upc.spring.service.IOficioService;
import pe.edu.upc.spring.service.ITrabajadorService;
import pe.edu.upc.spring.service.ITrabajadorOficioService;
//SolicitaTrabajador es TrabajadorOficio 	borrar TipoPago		Cliente es Trabajador		Trabajador es Oficio
@Controller
@RequestMapping("/trabajadorOficio")
public class TrabajadorOficioController {
	
	@Autowired
	private IOficioService oService;
	
	@Autowired
	private ITrabajadorService tService;
	
	@Autowired
	private ITrabajadorOficioService toService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoTrabajadorOficios(Map<String, Object> model) {
		model.put("listaTrabajadorOficios", toService.listar());
		return "listTrabajadorOficio";
	}
		
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroTrabajadoreOficios(Model model) {
		
		model.addAttribute("listaOficios", oService.listar());
		model.addAttribute("listaTrabajadores", tService.listar());
		
		model.addAttribute("oficio", new Oficio());
		model.addAttribute("trabajadorOficio", new TrabajadorOficio());
		model.addAttribute("trabajador", new Trabajador());
		
		return "trabajadorOficio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute TrabajadorOficio objTrabajadorOficio, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaOficios", oService.listar());
			model.addAttribute("listaTrabajadores", tService.listar());
			return "trabajadorOficio";
		}
		else {
			boolean flag = toService.insertar(objTrabajadorOficio);
			if (flag)
				return "redirect:/trabajadorOficio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/trabajadorOficio/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<TrabajadorOficio> objTrabajadorOficio = toService.listarId(id);
		if (objTrabajadorOficio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/trabajadorOficio/listar";
		}
		else {
			model.addAttribute("listaOficios", oService.listar());
			model.addAttribute("listaTrabajadores", tService.listar());
			
			if(objTrabajadorOficio.isPresent())
				objTrabajadorOficio.ifPresent(o -> model.addAttribute("trabajadorOficio", o));
			
			return "trabajadorOficio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				toService.eliminar(id);
				model.put("listaTrabajadorOficios", toService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTrabajadorOficios", toService.listar());
		}
		return "listTrabajadorOficio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTrabajadorOficios", toService.listar());
		return "listTrabajadorOficio";
	}
			
}
