package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.model.SolicitaTrabajador;

public interface IDistritoService {
		public Integer insertar(SolicitaTrabajador SolicitaTrabajador);
		public List<SolicitaTrabajador> fetchProductByProvincia(String nameprovincia);

		List <SolicitaTrabajador> listar();
		List <SolicitaTrabajador> findById(int idtrabajador);

}