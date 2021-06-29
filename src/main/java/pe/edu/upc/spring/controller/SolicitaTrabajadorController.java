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

import pe.edu.upc.spring.model.TipoPago;
import pe.edu.upc.spring.model.Trabajador;
import pe.edu.upc.spring.model.Cliente;
import pe.edu.upc.spring.model.SolicitaTrabajador;

import pe.edu.upc.spring.service.ITipoPagoService;
import pe.edu.upc.spring.service.ITrabajadorService;
import pe.edu.upc.spring.service.IClienteService;
import pe.edu.upc.spring.service.ISolicitaTrabajadorService;

@Controller
@RequestMapping("/solicitaTrabajador")
public class SolicitaTrabajadorController {
	
	@Autowired
	private ITipoPagoService tpService;
	
	@Autowired
	private ITrabajadorService tService;
	
	@Autowired
	private IClienteService cService;
	
	@Autowired
	private ISolicitaTrabajadorService stService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoSolicitaTrabajadores(Map<String, Object> model) {
		model.put("listaSolicitaTrabajadores", stService.listar());
		return "listSolicitaTrabajador";
	}
		
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroSolicitaTrabajadores(Model model) {
		
		model.addAttribute("listaTipoPagos", tpService.listar());
		model.addAttribute("listaTrabajadores", tService.listar());
		model.addAttribute("listaClientes", cService.listar());
		
		model.addAttribute("tipoPago", new TipoPago());
		model.addAttribute("trabajador", new Trabajador());
		model.addAttribute("solicitaTrabajador", new SolicitaTrabajador());
		model.addAttribute("cliente", new Cliente());
		
		return "solicitaTrabajador";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute SolicitaTrabajador objSolicitaTrabajador, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaTipoPagos", tpService.listar());	
			model.addAttribute("listaTrabajadores", tService.listar());
			model.addAttribute("listaClientes", cService.listar());
			return "solicitaTrabajador";
		}
		else {
			boolean flag = stService.insertar(objSolicitaTrabajador);
			if (flag)
				return "redirect:/solicitaTrabajador/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/solicitaTrabajador/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<SolicitaTrabajador> objSolicitaTrabajador = stService.listarId(id);
		if (objSolicitaTrabajador == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/solicitaTrabajador/listar";
		}
		else {
			model.addAttribute("listaTrabajadores", tService.listar());
			model.addAttribute("listaClientes", cService.listar());
			
			if(objSolicitaTrabajador.isPresent())
				objSolicitaTrabajador.ifPresent(o -> model.addAttribute("solicitaTrabajador", o));
			
			return "solicitaTrabajador";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				stService.eliminar(id);
				model.put("listaSolicitaTrabajadores", stService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaSolicitaTrabajadores", stService.listar());
		}
		return "listSolicitaTrabajador";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaSolicitaTrabajadores", stService.listar());
		return "listSolicitaTrabajador";
	}
			
}
