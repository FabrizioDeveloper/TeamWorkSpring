package pe.edu.upc.spring.model;

import java.io.Serializable;

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
public class Trabajador implements Serializable{

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
