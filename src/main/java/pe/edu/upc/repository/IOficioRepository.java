package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Oficio;

@Repository
public interface IOficioRepository extends JpaRepository<Oficio, Integer> {
	@Query("from Race r where r.nombreOficio like %:nombreOficio%")
	List<Oficio> buscaOficios(@Param("nombreOficio") String nombreOficio);
}
