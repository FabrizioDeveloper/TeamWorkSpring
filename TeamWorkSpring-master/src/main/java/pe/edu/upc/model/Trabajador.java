package pe.edu.upc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="trabajador")
public class Trabajador extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTrabajador;
	
	@OneToOne
	@JoinColumn(name = "idUsuario", nullable= false)
	private Usuario usuario;
	
	@Column(name="ruc", nullable=true, length=11)
	private String ruc;
	
	@Column(name="descripcionTrabajador", nullable=true, length=50)
	private String descripcionTrabajador;

	public Trabajador() {
		super();
	}

	public Trabajador(int idUsuario, String cuentaUsuario, String nombresUsuario, String apellidosUsuario,
			String correoUsuario, Date nacimientoUsuario, String sexo, String telefono, String claveUsuario,
			Distrito distrito) {
		super(idUsuario, cuentaUsuario, nombresUsuario, apellidosUsuario, correoUsuario, nacimientoUsuario, sexo, telefono,
				claveUsuario, distrito);
	}

	public Trabajador(int idTrabajador, Usuario usuario, String ruc, String descripcionTrabajador) {
		super();
		this.idTrabajador = idTrabajador;
		this.usuario = usuario;
		this.ruc = ruc;
		this.descripcionTrabajador = descripcionTrabajador;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getDescripcionTrabajador() {
		return descripcionTrabajador;
	}

	public void setDescripcionTrabajador(String descripcionTrabajador) {
		this.descripcionTrabajador = descripcionTrabajador;
	}
	
}
