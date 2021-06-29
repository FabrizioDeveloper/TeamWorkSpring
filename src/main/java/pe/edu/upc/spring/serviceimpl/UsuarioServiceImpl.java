package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Usuario;
import pe.edu.upc.spring.repository.IUsuarioRepository;
import pe.edu.upc.spring.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository dUsuario;
	
	@Override
	@Transactional
	public boolean insertar(Usuario usuario) {
		Usuario objUsuario = dUsuario.save(usuario);
		if (objUsuario == null)
			return false;
		else
			return true;
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
	
}
