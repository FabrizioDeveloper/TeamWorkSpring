package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.repository.IOficioRepository;
import pe.edu.upc.service.IOficioService;
import pe.edu.upc.model.Oficio;

@Service
public class OficioServiceImpl implements IOficioService{

	@Autowired
	private IOficioRepository dOficio;
	
	@Override
	@Transactional
	public boolean insertar(Oficio oficio) {
		Oficio objRace =dOficio.save(oficio);
		if (objRace == null )
			return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Oficio oficio) {
		boolean flag= false;
		
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
	public void eliminar(int idRace) {
		dOficio.deleteById(idRace);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Oficio> listarId(int idRace) {
		return dOficio.findById(idRace);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oficio> listar() {
		return dOficio.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Oficio> buscarOficios(String nombreOficios) {
		return dOficio.buscaOficios(nombreOficios);
	}

}
