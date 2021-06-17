package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Usuario;

public interface IUsuarioService {
	public boolean insertar(Usuario usuario);
	public boolean modificar(Usuario usuario);
	public void eliminar(int idUsuario);
	public Optional<Usuario> listarId(int idUsuario);
	public List<Usuario> listar();
	public List<Usuario> buscarCuentaUsuario(String cuentaUsuario);
	public List<Usuario> buscarDistrito(String nombreDistrito);
	
}
