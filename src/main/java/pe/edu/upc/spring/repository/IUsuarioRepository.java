package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	//public Usuario findByUsername(String cuentaUsuario);
	
	//public Usuario CuentaUsuario(String cuentaUsuario);
	
	@Query("from Usuario u where u.cuentaUsuario like %:cuentaUsuario%")
	List<Usuario> buscarCuentaUsuario(@Param("cuentaUsuario") String nameUsuario);

}
