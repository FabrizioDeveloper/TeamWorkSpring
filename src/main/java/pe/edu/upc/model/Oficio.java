package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oficio")
public class Oficio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idOficio;
	
	@Column(name="nombreOficio", nullable=false, length=20)
	private String nombreOficio;

	public Oficio() {
		super();
	}

	public Oficio(int idOficio, String nombreOficio) {
		super();
		this.idOficio = idOficio;
		this.nombreOficio = nombreOficio;
	}

	public int getIdOficio() {
		return idOficio;
	}

	public void setIdOficio(int idOficio) {
		this.idOficio = idOficio;
	}

	public String getNombreOficio() {
		return nombreOficio;
	}

	public void setNombreOficio(String nombreOficio) {
		this.nombreOficio = nombreOficio;
	}

}
