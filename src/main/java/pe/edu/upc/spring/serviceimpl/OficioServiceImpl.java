package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Oficio;
import pe.edu.upc.spring.repository.IOficioRepository;
import pe.edu.upc.spring.service.IOficioService;

@Service
public class OficioServiceImpl implements IOficioService {
	
	@Autowired
	private IOficioRepository dOficio;

	@Override
	@Transactional
	public boolean insertar(Oficio oficio) {
		Oficio objOficio = dOficio.save(oficio);
		if (objOficio == null) 
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Oficio oficio) {
		boolean flag = false;
		try {
			dOficio.save(oficio);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idOficio) {
		dOficio.deleteById(idOficio);		
	}

	@Override
	public Optional<Oficio> listarId(int idOficio) {
		return dOficio.findById(idOficio);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oficio> listar() {
		return dOficio.findAll();
	}
	
}
