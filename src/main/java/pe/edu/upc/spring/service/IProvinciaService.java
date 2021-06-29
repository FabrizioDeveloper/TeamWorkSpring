package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Provincia;

public interface IProvinciaService {
	public boolean insertar(Provincia provincia);
	public boolean modificar(Provincia provincia);
	public void eliminar(int idProvincia);
	public Optional<Provincia> listarId(int idProvincia);
	List<Provincia> listar();
}
