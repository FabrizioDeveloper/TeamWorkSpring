package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.model.Oficio;

public interface IOficioService {
	public boolean insertar(Oficio oficio);
	public boolean modificar(Oficio oficio);
	public void eliminar(int idOficio);
	public Optional<Oficio>listarId(int idOficio);
	List<Oficio>listar();
	List<Oficio>buscarOficios(String nombreOficios);
}
