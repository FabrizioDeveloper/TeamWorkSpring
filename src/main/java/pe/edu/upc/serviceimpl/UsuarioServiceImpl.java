package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Usuario;
import pe.edu.upc.repository.IUsuarioRepository;
import pe.edu.upc.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository dUsuario;

	@Override
	@Transactional
	public boolean insertar(Usuario usuario) {
		Usuario objUsuario = dUsuario.save(usuario);
		if (objUsuario != null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Usuario usuario) {
		boolean flag = false;
		try {
			dUsuario.save(usuario);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idUsuario) {
		dUsuario.deleteById(idUsuario);		
	}

	@Override
	public Optional<Usuario> listarId(int idUsuario) {
		return dUsuario.findById(idUsuario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> listar() {
		return dUsuario.findAll();
	}

	@Override
	@Transactional
	public List<Usuario> buscarCuentaUsuario(String cuentaUsuario) {
		return dUsuario.buscarCuentaUsuario(cuentaUsuario);
	}

	@Override
	public List<Usuario> buscarDistrito(String nombreDistrito) {
		return dUsuario.buscarDistrito(nombreDistrito);
	}
	
}
