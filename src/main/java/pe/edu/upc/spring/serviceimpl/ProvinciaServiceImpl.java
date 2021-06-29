package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Provincia;
import pe.edu.upc.spring.repository.IProvinciaRepository;
import pe.edu.upc.spring.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService {
	
	@Autowired
	private IProvinciaRepository dProvincia;

	@Override
	@Transactional
	public boolean insertar(Provincia provincia) {
		Provincia objProvincia = dProvincia.save(provincia);
		if (objProvincia == null)
			return false;
		else
			return true;		
	}

	@Override
	@Transactional
	public boolean modificar(Provincia provincia) {
		boolean flag = false;
		try {
			dProvincia.save(provincia);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idProvincia) {
		dProvincia.deleteById(idProvincia);		
	}

	@Override
	public Optional<Provincia> listarId(int idProvincia) {
		return dProvincia.findById(idProvincia);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Provincia> listar() {
		return dProvincia.findAll();
	}
	
}
