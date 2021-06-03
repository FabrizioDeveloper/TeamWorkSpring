package pe.edu.upc.Controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.model.Distrito;
import pe.edu.upc.service.IProvinciaService;
import pe.edu.upc.service.IDistritoService;

public class DistritoController {
	@Autowired
	private IProvinciaService cService;
	@Autowired
	private IDistritoService dService;

	@GetMapping("/new")
	public String newDistrito(Model model) {
		model.addAttribute("distrito", new Distrito());
		model.addAttribute("listProvincia", cService.listar());
		return "product/product";
	}

	@PostMapping("/save")
	public String saveProduct(Distrito distrito, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listProvincia", cService.listar());
			return "distrito/distrito";
		} else {
			int rpta = dService.insertar(distrito);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listProvincia", cService.listar());
				return "/distrito/distrito";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listdistritos", dService.listar());

		return "/distrito/listdistritos";
	}

	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("distrito", new Distrito());
			model.addAttribute("listdistritos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/distrito/listdistritos";
	}

	@GetMapping("/listFind")
	public String listProductFind(Model model) {
		try {
			model.addAttribute("distrito", new Distrito());
			model.addAttribute("listdistritos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("distrito", e.getMessage());
		}
		return "/product/find";
	}

	@RequestMapping("/find")
	public String find(Map<String, Object> model, @ModelAttribute Distrito distrito) throws ParseException {

		List<Distrito> listdistritos;

		distrito.setNombreDistrito(distrito.getNombreDistrito());
		listdistritos = dService.findByname(distrito.getNombreDistrito());

		if (listdistritos.isEmpty()) {
			listdistritos = dService.fetchProductByProvincia(distrito.getNombreDistrito());
		}

		if (listdistritos.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listProducts", listdistritos);
		return "distrito/find";

	}


}
