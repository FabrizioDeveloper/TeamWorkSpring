package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.TipoPago;

@Repository

public interface ITipoPagoRepository extends JpaRepository<TipoPago, Integer>  {

	@Query("select count (p.TipoPago) from TipoPago p where p.idProvincia = :TipoPago")
	public int buscarTipoPago(@Param("TipoPago") int TipoPago);
	
	@Query("select p from TipoPago p where p.Nombreusuario like %:Nombreusuario%:")
	List<Nombreusuario> FindByName(String Nombreusuario);
	
}
