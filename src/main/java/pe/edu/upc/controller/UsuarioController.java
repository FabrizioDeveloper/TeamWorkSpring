package pe.edu.upc.controller;

import java.util.List;
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

import pe.edu.upc.model.Distrito;
import pe.edu.upc.model.Usuario;

import pe.edu.upc.service.IUsuarioService;
import pe.edu.upc.service.IDistritoService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService uService;
	
	@Autowired
	private IDistritoService dService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	
	@RequestMapping("/")
	public String irPaginaListadoUsuarios(Map<String, Object> model) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuario";
	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroUsuarios(Model model) {
		
		model.addAttribute("listaRazas", dService.listar());
		
		model.addAttribute("distrito", new Distrito());
		model.addAttribute("usuario", new Usuario());
		
		return "usuario";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Usuario objUsuario, BindingResult binRes, Model model) 
			throws ParseException {
		
		if (binRes.hasErrors()) {
			
			model.addAttribute("listaDistritos", dService.listar());
			return "usuario";
		}
		else {
			boolean flag = uService.insertar(objUsuario);
			if (flag)
				return "redirect:/usuario/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/usuario/irRegistrar";
			}
		}			
	}
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException {
		Optional<Usuario> objUsuario = uService.listarId(id);
		if (objUsuario == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/usuario/listar";
		}
		else {
			model.addAttribute("listaDistritos", dService.listar());
			
			if(objUsuario.isPresent())
				objUsuario.ifPresent(o -> model.addAttribute("usuario", o));
			
			return "usuario";
		}
	}
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if (id != null && id > 0) {
				uService.eliminar(id);
				model.put("listaUsuarios", uService.listar());
			}			
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaUsuarios", uService.listar());
		}
		return "listUsuario";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaUsuarios", uService.listar());
		return "listUsuario";
	}
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model, @ModelAttribute Usuario usuario)
	throws ParseException
	{
		uService.listarId(usuario.getIdUsuario());
		return "listUsuario";
	}
	
	@RequestMapping("/irBuscar")
	public String irBuscar(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "buscar";
	}
	
	@RequestMapping("/buscar")
	public String buscar(Map<String, Object> model, @ModelAttribute Usuario usuario) 
	throws ParseException
	{
		List<Usuario> listaUsuarios;
		usuario.setCuentaUsuario(usuario.getCuentaUsuario());
		listaUsuarios = uService.buscarCuentaUsuario(usuario.getCuentaUsuario());
		
		if (listaUsuarios.isEmpty()) {
			model.put("mensaje", "No existe coincidencias");
		}
		else
			model.put("listaUsuarios", listaUsuarios);
		return "buscar";
	}
	
}
