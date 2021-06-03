package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.TrabajadorOficio;

public interface ITrabajadorOficioService {
	public boolean insertar(TrabajadorOficio trabajdorOficio);
	public boolean modificar(TrabajadorOficio trabajadorOficio);
	public void eliminar(int idOficio);
	public Optional<TrabajadorOficio>listarId(int idTrabajadorOficio);
	List<TrabajadorOficio>listar();
}
