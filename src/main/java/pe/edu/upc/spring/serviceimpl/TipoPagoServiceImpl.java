package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.TipoPago;
import pe.edu.upc.spring.repository.ITipoPagoRepository;
import pe.edu.upc.spring.service.ITipoPagoService;

@Service
public class TipoPagoServiceImpl implements ITipoPagoService {
	
	@Autowired
	private ITipoPagoRepository dTipoPago;

	@Override
	@Transactional
	public boolean insertar(TipoPago tipoPago) {
		TipoPago objTipoPago = dTipoPago.save(tipoPago);
		if (objTipoPago == null) 
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(TipoPago tipoPago) {
		boolean flag = false;
		try {
			dTipoPago.save(tipoPago);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idTipoPago) {
		dTipoPago.deleteById(idTipoPago);		
	}

	@Override
	public Optional<TipoPago> listarId(int idTipoPago) {
		return dTipoPago.findById(idTipoPago);
	}

	@Override
	@Transactional(readOnly = true)
	public List<TipoPago> listar() {
		return dTipoPago.findAll();
	}
	
}
