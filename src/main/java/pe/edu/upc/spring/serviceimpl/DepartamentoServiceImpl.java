package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Departamento;
import pe.edu.upc.spring.repository.IDepartamentoRepository;
import pe.edu.upc.spring.service.IDepartamentoService;

@Service
public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private IDepartamentoRepository dDepartamento;

	@Override
	@Transactional
	public boolean insertar(Departamento departamento) {
		Departamento objDepartamento = dDepartamento.save(departamento);
		if (objDepartamento == null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Departamento departamento) {
		boolean flag = false;
		try {
			dDepartamento.save(departamento);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idDepartamento) {
		dDepartamento.deleteById(idDepartamento);		
	}

	@Override
	public Optional<Departamento> listarId(int idDepartamento) {
		return dDepartamento.findById(idDepartamento);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> listar() {
		return dDepartamento.findAll();
	}
	
}
