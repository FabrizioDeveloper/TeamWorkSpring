package pe.edu.upc.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.SolicitaTrabajador;
import pe.edu.upc.repository.ISolicitaTrabajadorRepository;
import pe.edu.upc.service.ISolicitaTrabajadorService;

public class SolicitaTrabajadorServiceImpl implements ISolicitaTrabajadorService {

	@Autowired
	private ISolicitaTrabajadorRepository dD;

	@Override
	@Transactional
	public Integer insertar(SolicitaTrabajador SolicitaTrabajador) {
		int rpta = dD.buscaridTrabajador(SolicitaTrabajador.getIdTrabajador());
		if (rpta == 0)
			dD.save(SolicitaTrabajador);
		return rpta;
	}

	@Override
	@Transactional (readOnly = true)
	public List<SolicitaTrabajador> listar() {
		List<SolicitaTrabajador> lista = dD.findAll();
		return lista;
	}

	@Override
	@Transactional (readOnly = true)
	public List<SolicitaTrabajador> findByname(Int idTrabajador) {
		List<SolicitaTrabajador> lista = dD.FindById(idTrabajador);
		return lista;	
	}
}
