package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Departamento;

public interface IDepartamentoService {
		public Integer insertar(Departamento departamento);
		List <Departamento> listar();
		List <Departamento> findByname(String nombreDepartamento);

}
