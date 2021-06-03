package pe.edu.upc.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.model.Departamento;
import pe.edu.upc.service.IDepartamentoService;



@Controller
@RequestMapping("/departamento")

public class DepartamentoController {
	
	@Autowired
	private IDepartamentoService dService;

	@GetMapping("/new")
	public String newCategory(Model model) {
		model.addAttribute("departamento", new Departamento());
		return "departamento/departamento";
	}

	@PostMapping("/save")
	public String saveCategory( Departamento departamento, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "departamento/departamento";
		} else {
			int rpta = dService.insertar(departamento);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/departamento/departamento";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listDepartamento", dService.listar());

		return "/departamento/departamento";
	}

	@GetMapping("/list")
	public String listCategories(Model model) {
		try {
			model.addAttribute("departamento", new Departamento());
			model.addAttribute("listDepartamento", dService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/departamento/listDepartamento";
	}
	@RequestMapping("/find")
	public String findByCategory(Map<String, Object> model, @ModelAttribute Departamento departamento) throws ParseException {

		List<Departamento> listDepartamento;
		departamento.setNombreDepartamento(departamento.getNombreDepartamento());
		listDepartamento = dService.findByname(departamento.getNombreDepartamento());
		if (listDepartamento.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listDepartamento", listDepartamento);
		return "departamento/find";

	}

	
}
	
