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

import pe.edu.upc.spring.model.TipoPago;
import pe.edu.upc.spring.service.ITipoPagoService;

@Controller
@RequestMapping("/tipoPago")
public class TipoPagoController {
	
	@Autowired
	private ITipoPagoService tpService;
	
	@RequestMapping("/bienvenido")
	public String irTipoPagoBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irTipoPago(Map<String, Object> model) {
		model.put("listaTipoPagos", tpService.listar());
		return "listTipoPago";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("tipoPago", new TipoPago());
		return "tipoPago";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute TipoPago objTipoPago, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors())
			return "tipoPago";
		else {
			boolean flag = tpService.insertar(objTipoPago);
			if (flag)
				return "redirect:/tipoPago/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/tipoPago/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<TipoPago> objTipoPago = tpService.listarId(id);
		if (objTipoPago == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/tipoPago/listar";
		}
		else {
			model.addAttribute("tipoPago", objTipoPago);
			return "tipoPago";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				tpService.eliminar(id);
				model.put("listaTipoPagos", tpService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaTipoPagos", tpService.listar());
		}
		return "listTipoPago";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaTipoPagos", tpService.listar());
		return "listTipoPago";
	}
	
}
