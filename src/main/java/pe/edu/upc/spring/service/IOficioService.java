package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Oficio;

public interface IOficioService {
	public boolean insertar(Oficio oficio);
	public boolean modificar(Oficio oficio);
	public void eliminar(int idOficio);
	public Optional<Oficio> listarId(int idOficio);
	List<Oficio> listar();
}
