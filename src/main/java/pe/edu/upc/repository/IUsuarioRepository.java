package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	@Query("from Usuario u where u.cuentaUsuario like %:cuentaUsuario%")
	List<Usuario> buscarCuentaUsuario(@Param("cuentaUsuario") String nameUsuario);
	
	@Query("from Usuario u where u.distrito.nombreDistrito like %:nombreDistrito%")
	List<Usuario> buscarDistrito(@Param("nombreDistrito") String nombreDistrito);
	
}
