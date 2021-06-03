package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Trabajador;

@Repository
public interface ITrabajadorRepository extends JpaRepository<Trabajador, Integer>{
	
}
