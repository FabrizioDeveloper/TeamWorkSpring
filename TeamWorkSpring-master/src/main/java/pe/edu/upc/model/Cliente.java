package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idCliente;
	
	@OneToOne
	@JoinColumn(name = "idUsuario", nullable= false)
	private Usuario usuario;
	
	private int bonificacion;

	public Cliente() {
		super();
	}

	public Cliente(int idUsuario, String cuentaUsuario, String nombresUsuario, String apellidosUsuario,
			String correoUsuario, Date nacimientoUsuario, String sexo, String telefono, String claveUsuario,
			Distrito distrito) {
		super(idUsuario, cuentaUsuario, nombresUsuario, apellidosUsuario, correoUsuario, nacimientoUsuario, sexo, telefono,
				claveUsuario, distrito);
	}

	public Cliente(int idCliente, Usuario usuario, int bonificacion) {
		super();
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.bonificacion = bonificacion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(int bonificacion) {
		this.bonificacion = bonificacion;
	}
	
}
