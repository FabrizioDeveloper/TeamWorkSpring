package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Trabajador;

public interface ITrabajadorService {
	public boolean insertar(Trabajador trabajador);
	public boolean modificar(Trabajador trabajador);
	public void eliminar(int idTrabajador);
	public Optional<Trabajador> listarId(int idTrabajador);
	List<Trabajador> listar();
}
