package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Sexo;
import pe.edu.upc.spring.repository.ISexoRepository;
import pe.edu.upc.spring.service.ISexoService;

@Service
public class SexoServiceImpl implements ISexoService {
	
	@Autowired
	private ISexoRepository dSexo;

	@Override
	@Transactional
	public boolean insertar(Sexo sexo) {
		Sexo objSexo = dSexo.save(sexo);
		if (objSexo == null) 
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Sexo sexo) {
		boolean flag = false;
		try {
			dSexo.save(sexo);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idSexo) {
		dSexo.deleteById(idSexo);		
	}

	@Override
	public Optional<Sexo> listarId(int idSexo) {
		return dSexo.findById(idSexo);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sexo> listar() {
		return dSexo.findAll();
	}
	
}
