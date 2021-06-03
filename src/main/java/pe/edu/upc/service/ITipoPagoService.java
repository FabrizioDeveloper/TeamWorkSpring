package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.TipoPago;

public interface ITipoPagoService {
		public Integer insertar(TipoPago TipoPago);
		List <TipoPago> listar();
		List <TipoPago> findById(Int idtrabajador);

}
