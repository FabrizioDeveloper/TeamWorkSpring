package pe.edu.upc.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.Distrito;
import pe.edu.upc.repository.IdistritoRepository;
import pe.edu.upc.service.IDistritoService;


public class DistritoServiceImpl implements IDistritoService {

	@Autowired
	private IdistritoRepository dD;

	@Override
	@Transactional
	public Integer insertar(Distrito distrito) {
		int rpta = dD.buscarDistritoID(distrito.getIdDistrito());
		if (rpta == 0)
			dD.save(distrito);
		return rpta;		
	}

	@Override
	@Transactional (readOnly = true)
	public List<Distrito> listar() {
		List<Distrito> lista = dD.findAll();
			return lista ;
	}

	@Override
	@Transactional (readOnly = true)
	public List<Distrito> findByname(String nombreDistrito) {
		List<Distrito> lista = dD.FindByName(nombreDistrito);
		return lista;	
	}

	@Override
	public List<Distrito> fetchProductByProvincia(String nameprovincia) {
			return dD.findProductBynameProvincia(nameprovincia);		
	}
	
}
