package pe.edu.upc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Departamento;

@Repository

public interface IDepartamentoRepository extends JpaRepository<Departamento, Integer>  {

//validaciondeid
	@Query("select count (d.idDepartamento) from Departamento d where d.idDepartamento = :idDepartamento")
	public int buscarDepaID(@Param("idDepartamento") int idDepartamento);
	//busqueda
	@Query("select d from Departamento p where d.nombreDistrito like %:nombreDistrito%:")
	List<Departamento> FindByName(String nombreDepartamento);

}
