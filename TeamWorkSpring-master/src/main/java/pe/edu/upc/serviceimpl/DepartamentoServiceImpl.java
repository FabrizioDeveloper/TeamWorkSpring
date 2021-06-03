package pe.edu.upc.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Departamento;
import pe.edu.upc.repository.IDepartamentoRepository;
import pe.edu.upc.service.IDepartamentoService;

public class DepartamentoServiceImpl implements IDepartamentoService {

	@Autowired
	private IDepartamentoRepository dD;

	@Override
	@Transactional
	public Integer insertar(Departamento departamento) {
		int rpta = dD.buscarDepaID(departamento.getIdDepartamento());
		if (rpta == 0)
			dD.save(departamento);
		return rpta;
	}

	@Override
	@Transactional (readOnly = true)
	public List<Departamento> listar() {
		List<Departamento> lista = dD.findAll();
		return lista;
	}

	@Override
	@Transactional (readOnly = true)
	public List<Departamento> findByname(String nombreDepartamento) {
		List<Departamento> lista = dD.FindByName(nombreDepartamento);
		return lista;	
	}
}
