package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Oficio;
import pe.edu.upc.spring.service.IOficioService;

@Controller
@RequestMapping("/oficio")
public class OficioController {
	
	@Autowired
	private IOficioService oService;
	
	@RequestMapping("/bienvenido")
	public String irOficioBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irOficio(Map<String, Object> model) {
		model.put("listaOficios", oService.listar());
		return "listOficio";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("oficio", new Oficio());
		return "oficio";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Oficio objOficio, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors())
			return "oficio";
		else {
			boolean flag = oService.insertar(objOficio);
			if (flag)
				return "redirect:/oficio/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/oficio/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Oficio> objOficio = oService.listarId(id);
		if (objOficio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/oficio/listar";
		}
		else {
			model.addAttribute("oficio", objOficio);
			return "oficio";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				oService.eliminar(id);
				model.put("listaOficios", oService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaOficios", oService.listar());
		}
		return "listOficio";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaOficios", oService.listar());
		return "listOficio";
	}
	
}
