package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Provincia;

public interface IProvinciaService {
		public Integer insertar(Provincia provincia);
		List <Provincia> listar();
		List <Provincia> findByname(String nombreProvincia);
		public List<Provincia> fetchProductByDepartamento(String namedepartamento);

}

