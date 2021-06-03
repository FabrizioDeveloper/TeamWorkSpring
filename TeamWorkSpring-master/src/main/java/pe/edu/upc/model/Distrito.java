package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="distrito")
public class Distrito implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idDistrito;
	
	@Column(name="nombreDistrito", nullable=false, length=20)
	private String nombreDistrito;
	
	@ManyToOne
	@JoinColumn(name= "idProvincia", nullable=false)
	private Provincia provincia;

	public Distrito() {
		super();
	}

	public Distrito(int idDistrito, String nombreDistrito, Provincia provincia) {
		super();
		this.idDistrito = idDistrito;
		this.nombreDistrito = nombreDistrito;
		this.provincia = provincia;
	}

	public int getIdDistrito() {
		return idDistrito;
	}

	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}

	public String getNombreDistrito() {
		return nombreDistrito;
	}

	public void setNombreDistrito(String nombreDistrito) {
		this.nombreDistrito = nombreDistrito;
	}

	public Provincia getProvincia() {
		return provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	
}
