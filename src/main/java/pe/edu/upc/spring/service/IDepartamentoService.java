package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Departamento;

public interface IDepartamentoService {
	public boolean insertar(Departamento departamento);
	public boolean modificar(Departamento departamento);
	public void eliminar(int idDepartamento);
	public Optional<Departamento> listarId(int idDepartamento);
	List<Departamento> listar();
}
