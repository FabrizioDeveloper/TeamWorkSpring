package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idUsuario;
	
	@Column(name="cuentaUsuario", nullable=false, length=11)
	private String cuentaUsuario;
	
	@Column(name="nombresUsuario", nullable=false, length=20)
	private String nombresUsuario;
	
	@Column(name="apellidosUsuario", nullable=false, length=20)
	private String apellidosUsuario;
	
	@Column(name="correoUsuario", nullable=false, length=20)
	private String correoUsuario;
	
	private Date nacimientoUsuario;
	
	@Column(nullable = false)
	private String sexo;
	
	@Column(nullable = false)
	private String tipoUsuario;
	
	@Column(name="telefono", nullable=false, length=9)
	private String telefono;
	
	@Column(length=20)
	private String claveUsuario;
	
	@ManyToOne
	@JoinColumn(name = "idDistrito", nullable = false)
	private Departamento distrito;

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCuentaUsuario() {
		return cuentaUsuario;
	}

	public void setCuentaUsuario(String cuentaUsuario) {
		this.cuentaUsuario = cuentaUsuario;
	}

	public String getNombresUsuario() {
		return nombresUsuario;
	}

	public void setNombresUsuario(String nombresUsuario) {
		this.nombresUsuario = nombresUsuario;
	}

	public String getApellidosUsuario() {
		return apellidosUsuario;
	}

	public void setApellidosUsuario(String apellidosUsuario) {
		this.apellidosUsuario = apellidosUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public Date getNacimientoUsuario() {
		return nacimientoUsuario;
	}

	public void setNacimientoUsuario(Date nacimientoUsuario) {
		this.nacimientoUsuario = nacimientoUsuario;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getClaveUsuario() {
		return claveUsuario;
	}

	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}

	public Departamento getDistrito() {
		return distrito;
	}

	public void setDistrito(Departamento distrito) {
		this.distrito = distrito;
	}
	
}
