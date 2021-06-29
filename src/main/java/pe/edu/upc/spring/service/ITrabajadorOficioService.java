package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.TrabajadorOficio;

public interface ITrabajadorOficioService {
	public boolean insertar(TrabajadorOficio trabajadorOficio);
	public boolean modificar(TrabajadorOficio trabajadorOficio);
	public void eliminar(int idTrabajadorOficio);
	public Optional<TrabajadorOficio> listarId(int idTrabajadorOficio);
	List<TrabajadorOficio> listar();
}
