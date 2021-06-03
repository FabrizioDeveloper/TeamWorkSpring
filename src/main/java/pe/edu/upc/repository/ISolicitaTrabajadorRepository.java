package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.SolicitaTrabajador;

@Repository

public interface IsolicitatrabajadorRepository extends JpaRepository<solicitatrabajador, Integer>  {

	@Query("select count (d.idTrabajador) from solicitatrabajador d where d.idTrabajador = :idTrabajador")
	public int buscarsolicitatrabajadorID(@Param("idTrabajador") int idTrabajador);
	
	@Query("select d from SolicitaTrabajador p where d.idTrabajador like %:idTrabajador%:")
	List<SolicitaTrabajador> FindById(Int idTrabajador);


}
