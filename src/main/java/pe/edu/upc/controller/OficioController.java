package pe.edu.upc.controller;

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

import pe.edu.upc.model.Oficio;
import pe.edu.upc.service.IOficioService;

@Controller
@RequestMapping("/race")
public class OficioController {
	
	@Autowired
	private IOficioService rService;

	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
		
	}
	@RequestMapping("/")
	public String irPaginaListadoRazas(Map<String, Object> model) {
		model.put("listaRzas", rService.listar());
		return "listRace";
	}
	@RequestMapping("/irRegistar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("race", new Oficio());
		return "race";
	}
	@RequestMapping("/irRegistar")
	public String registar(@ModelAttribute Oficio objOficio, BindingResult binRes, Model model) 
	throws ParseException {
		if (binRes.hasErrors())
			return "race";
		else {
			boolean flag = rService.insertar(objOficio);
			if (flag)
				return "redirect:/race/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/race/listar";
			}
		}
		
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir)
	throws ParseException {
		Optional<Oficio> objOficio = rService.listarId(id);
		if(objOficio == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/race/listar";
		}
		else {
			model.addAttribute("race", objOficio);
			return "race";
		}
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object>model, @RequestParam(value="id") Integer id) {
		try {
			if (id!=null && id>0) {
				rService.eliminar(id);
				model.put("listaRazas", rService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaRazas", rService.listar());
		}
		return "listRace";
	}
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaRazas", rService.listar());
		return "listRace";
	}
	
}