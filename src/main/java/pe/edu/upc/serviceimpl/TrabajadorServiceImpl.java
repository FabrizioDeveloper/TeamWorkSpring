package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Trabajador;
import pe.edu.upc.repository.ITrabajadorRepository;
import pe.edu.upc.service.ITrabajadorService;

@Service
public class TrabajadorServiceImpl implements ITrabajadorService {

	@Autowired
	private ITrabajadorRepository dTrabajador;
	
	@Override
	@Transactional
	public boolean insertar(Trabajador trabajador) {
		Trabajador objTrabajador = dTrabajador.save(trabajador);
		if (objTrabajador == null)
			return false;
		else
			return true;		
	}

	@Override
	@Transactional
	public boolean modificar(Trabajador trabajador) {
		boolean flag = false;
		try {
			dTrabajador.save(trabajador);
			flag = true;
		}
		catch (Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTrabajador) {
		dTrabajador.deleteById(idTrabajador);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Trabajador> listarId(int idTrabajador) {
		return dTrabajador.findById(idTrabajador);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Trabajador> listar() {
		return dTrabajador.findAll();
	}

}
