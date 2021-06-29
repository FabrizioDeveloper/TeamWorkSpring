package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.TipoPago;

public interface ITipoPagoService {
	public boolean insertar(TipoPago tipoPago);
	public boolean modificar(TipoPago tipoPago);
	public void eliminar(int idTipoPago);
	public Optional<TipoPago> listarId(int idTipoPago);
	List<TipoPago> listar();
}
