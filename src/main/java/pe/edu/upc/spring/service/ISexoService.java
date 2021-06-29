package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Sexo;

public interface ISexoService {
	public boolean insertar(Sexo sexo);
	public boolean modificar(Sexo sexo);
	public void eliminar(int idSexo);
	public Optional<Sexo> listarId(int idSexo);
	List<Sexo> listar();
}
