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

import pe.edu.upc.model.Provincia;
import pe.edu.upc.service.IDepartamentoService;
import pe.edu.upc.service.IProvinciaService;

public class ProvinciaController {

	@Autowired
	private IDepartamentoService cService;
	@Autowired
	private IProvinciaService dService;

	@GetMapping("/new")
	public String newDistrito(Model model) {
		model.addAttribute("distrito", new Provincia());
		model.addAttribute("listDepartamento", cService.listar());
		return "product/product";
	}

	@PostMapping("/save")
	public String saveProduct(Provincia provincia, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listDepartamento", cService.listar());
			return "distrito/distrito";
		} else {
			int rpta = dService.insertar(provincia);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listCategories", cService.listar());
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
			model.addAttribute("distrito", new Provincia());
			model.addAttribute("listdistritos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/distrito/listdistritos";
	}

	@GetMapping("/listFind")
	public String listProductFind(Model model) {
		try {
			model.addAttribute("distrito", new Provincia());
			model.addAttribute("listdistritos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("distrito", e.getMessage());
		}
		return "/product/find";
	}

	@RequestMapping("/find")
	public String find(Map<String, Object> model, @ModelAttribute Provincia provincia) throws ParseException {

		List<Provincia> listprovincia;

		provincia.setNombreProvincia(provincia.getNombreProvincia());
		listprovincia = dService.findByname(provincia.getNombreProvincia());

		if (listprovincia.isEmpty()) {
			listprovincia = dService.fetchProductByDepartamento(provincia.getNombreProvincia());
		}

		if (listprovincia.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listProducts", listprovincia);
		return "product/find";

	}
}
