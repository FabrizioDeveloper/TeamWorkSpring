package pe.edu.upc.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

public class TipoPagoController {

	@Autowired
	private ITipoPagoService cService;

	}

	@PostMapping("/save")
	public String saveProduct(Provincia provincia, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listTipoPago", cService.listar());
			return "TipoPago";
		} else {
			int rpta = dService.insertar(TipoPago);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listCategories", cService.listar());
				return "/Tipopago/Tipopago";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listTipopago", dService.listar());

		return "/Tipopago/listTipopago";
	
}
