package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Provincia;

@Repository

public interface IProvinciaRepository extends JpaRepository<Provincia, Integer>  {

	@Query("select count (p.idProvincia) from Provincia p where p.idProvincia = :idProvincia")
	public int buscarProvincia(@Param("idProvincia") int idProvincia);
	
	@Query("select p from Provincia p where p.nombreProvincia like %:nombreProvincia%:")
	List<Provincia> FindByName(String nombreProvincia);
	
	@Query("select p from Provincia d where p.Departamento.nombreDepartamento like %?1%")
	public List<Provincia> findProductBynameDepartamento(String nombreDepartamento);
}
