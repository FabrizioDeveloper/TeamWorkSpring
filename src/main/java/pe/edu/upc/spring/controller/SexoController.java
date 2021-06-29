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

import pe.edu.upc.spring.model.Sexo;
import pe.edu.upc.spring.service.ISexoService;

@Controller
@RequestMapping("/sexo")
public class SexoController {
	
	@Autowired
	private ISexoService sService;
	
	@RequestMapping("/bienvenido")
	public String irSexoBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irSexo(Map<String, Object> model) {
		model.put("listaSexos", sService.listar());
		return "listSexo";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("sexo", new Sexo());
		return "sexo";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Sexo objSexo, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors())
			return "sexo";
		else {
			boolean flag = sService.insertar(objSexo);
			if (flag)
				return "redirect:/sexo/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/sexo/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Sexo> objSexo = sService.listarId(id);
		if (objSexo == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/sexo/listar";
		}
		else {
			model.addAttribute("sexo", objSexo);
			return "sexo";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				sService.eliminar(id);
				model.put("listaSexos", sService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaSexos", sService.listar());
		}
		return "listSexo";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaSexos", sService.listar());
		return "listSexo";
	}
	
}
