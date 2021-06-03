package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Provincia;
import pe.edu.upc.repository.IProvinciaRepository;
import pe.edu.upc.service.IProvinciaService;

@Service
public class ProvinciaServiceImpl implements IProvinciaService{
	
	@Autowired
	private IProvinciaRepository pP;

	@Override
	@Transactional
	public Integer insertar(Provincia provincia) {
		// TODO Auto-generated method stub
		int rpta = pP.buscarProvincia(provincia.getIdProvincia());
		if (rpta == 0)
			pP.save(provincia);
		return rpta;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Provincia> listar() {
		List<Provincia> lista = pP.findAll();
		return lista ;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Provincia> findByname(String nombreProvincia) {
		List<Provincia> lista = pP.FindByName(nombreProvincia);
		return lista;
	}

	@Override
	public List<Provincia> fetchProductByDepartamento(String namedepartamento) {
		return pP.findProductBynameDepartamento(namedepartamento);		
	}

}
