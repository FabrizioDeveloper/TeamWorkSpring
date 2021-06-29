package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Trabajador;

public interface ITrabajadorService {
	public boolean insertar(Trabajador trabajador);
	public boolean modificar(Trabajador trabajador);
	public void eliminar(int idTrabajador);
	public Optional<Trabajador> listarId(int idTrabajador);
	List<Trabajador> listar();
}
