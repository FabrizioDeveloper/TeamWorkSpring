package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.SolicitaTrabajador;

public interface ISolicitaTrabajadorService {
	public boolean insertar(SolicitaTrabajador solicitaTrabajador);
	public boolean modificar(SolicitaTrabajador solicitaTrabajador);
	public void eliminar(int idSolicitaTrabajador);
	public Optional<SolicitaTrabajador> listarId(int idSolicitaTrabajador);
	List<SolicitaTrabajador> listar();
}
