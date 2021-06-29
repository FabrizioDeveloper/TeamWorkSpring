package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SolicitaTrabajador;
import pe.edu.upc.spring.repository.ISolicitaTrabajadorRepository;
import pe.edu.upc.spring.service.ISolicitaTrabajadorService;

@Service
public class SolicitaTrabajadorServiceImpl implements ISolicitaTrabajadorService {
	
	@Autowired
	private ISolicitaTrabajadorRepository dSolicitaTrabajador;

	@Override
	@Transactional
	public boolean insertar(SolicitaTrabajador solicitaTrabajador) {
		SolicitaTrabajador objSolicitaTrabajador = dSolicitaTrabajador.save(solicitaTrabajador);
		if (objSolicitaTrabajador == null) 
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(SolicitaTrabajador solicitaTrabajador) {
		boolean flag = false;
		try {
			dSolicitaTrabajador.save(solicitaTrabajador);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idSolicitaTrabajador) {
		dSolicitaTrabajador.deleteById(idSolicitaTrabajador);		
	}

	@Override
	public Optional<SolicitaTrabajador> listarId(int idSolicitaTrabajador) {
		return dSolicitaTrabajador.findById(idSolicitaTrabajador);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SolicitaTrabajador> listar() {
		return dSolicitaTrabajador.findAll();
	}
	
}
