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

import pe.edu.upc.model.SolicitaTrabajador;
import pe.edu.upc.service.ISolicitaTrabajadorService;


public class SolicitaTrabajadorController {
	@Autowired
	private ISolicitaTrabajadorService cService;

	@GetMapping("/new")
	public String newDistrito(Model model) {
		model.addAttribute("SolicitudTrabajo", new SolicitudTrabajo());
		model.addAttribute("listSolicitudTrabajo", cService.listar());
		return "SolicitudTrabajo/SolicitudTrabajo";
	}

	@PostMapping("/save")
	public String saveProduct(SolicitudTrabajo SolicitudTrabajo, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listSolicitudTrabajos", cService.listar());
			return "SolicitudTrabajo/SolicitudTrabajo";
		} else {
			int rpta = dService.insertar(SolicitudTrabajo);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listSolicitudTrabajo", cService.listar());
				return "/distrito/distrito";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listSolicitudTrabajo", dService.listar());

		return "/SolicitudTrabajos/listSolicitudTrabajos";
	}

	@GetMapping("/list")
	public String listProduct(Model model) {
		try {
			model.addAttribute("SolicitudTrabajo", new Distrito());
			model.addAttribute("listSolicitudTrabajos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/SolicitudTrabajos/listSolicitudTrabajos";
	}

	@GetMapping("/listFind")
	public String listProductFind(Model model) {
		try {
			model.addAttribute("SolicitudTrabajo", new SolicitudTrabajo());
			model.addAttribute("listSolicitudTrabajos", dService.listar());
		} catch (Exception e) {
			model.addAttribute("SolicitudTrabajo", e.getMessage());
		}
		return "/SolicitudTrabajo/find";
	}

	@RequestMapping("/find")
	public String find(Map<String, Object> model, @ModelAttribute Distrito distrito) throws ParseException {

		List<SolicitudTrabajos> listSolicitudTrabajo;

		SolicitudTrabajo.setIdSolicitaTrabajador(SolicitaTrabajado.getIdSolicitaTrabajador());
		listSolicitaTrabajado = dService.findByname(distrito.getIdSolicitaTrabajado());

		if (listSolicitaTrabajaos.isEmpty()) {
			listSolicitaTrabajado = dService.fetchProductByTipoPago(SolicitaTrabajado.getIdSolicitaTrabajador());
		}

		if (listSolicitaTrabajos.isEmpty()) {
			model.put("mensaje", "No se encontró");
		}
		model.put("listProducts", listSolicitaTrabajos);
		return "SolicitaTrabajos/find";

	}


}
