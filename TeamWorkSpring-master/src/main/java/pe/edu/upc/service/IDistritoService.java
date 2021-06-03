package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.Distrito;

public interface IDistritoService {
		public Integer insertar(Distrito distrito);
		public List<Distrito> fetchProductByProvincia(String nameprovincia);

		List <Distrito> listar();
		List <Distrito> findByname(String nombreDistrito);

}