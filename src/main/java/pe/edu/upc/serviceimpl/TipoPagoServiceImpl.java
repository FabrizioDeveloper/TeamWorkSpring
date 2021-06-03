package pe.edu.upc.serviceimpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.model.TipoPago;
import pe.edu.upc.repository.ITipoPagoRepository;
import pe.edu.upc.service.TipoPagoServiceImpl;


public class TipoPagoServiceImpl implements TipoPagoService {

	@Autowired
	private IdistritoRepository dD;

	@Override
	@Transactional
	public Integer insertar(TipoPago TipoPago) {
		int rpta = dD.buscarTipoPago(TipoPago.getTipoPago());
		if (rpta == 0)
			dD.save(TipoPago);
		return rpta;		
	}

	@Override
	@Transactional (readOnly = true)
	public List<TipoPago> listar() {
		List<TipoPago> lista = dD.findAll();
			return lista ;
	}

	@Override
	@Transactional (readOnly = true)
	public List<TipoPago> findByname(String Nombreusuario) {
		List<TipoPago> lista = dD.FindByName(Nombreusuario);
		return lista;	
	}

	@Override
	public List<TipoPago> fetchProductByTipoPago(String Nombreusuario) {
			return dD.findProductBynameTipoPago(Nombreusuario);		
	}
	
}
