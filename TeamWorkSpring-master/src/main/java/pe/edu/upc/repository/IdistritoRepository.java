package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Distrito;

@Repository

public interface IdistritoRepository extends JpaRepository<Distrito, Integer>  {

	@Query("select count (d.idDistrito) from Distrito d where d.idDistrito = :idDistrito")
	public int buscarDistritoID(@Param("idDistrito") int idDistrito);
	
	@Query("select d from Distrito p where d.nombreDistrito like %:nombreDistrito%:")
	List<Distrito> FindByName(String nombreDistrito);
	
	@Query("select d from distrito d where d.Provincia.nombreProvincia like %?1%")
	public List<Distrito> findProductBynameProvincia(String nombreprovincia);

}
