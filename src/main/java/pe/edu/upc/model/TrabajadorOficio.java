package pe.edu.upc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="trabajadorOficio")
public class TrabajadorOficio implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTrabajadorOficio;
	
	@ManyToOne
	@JoinColumn(name= "idTrabajador", nullable=false)
	private Trabajador trabajador;
	
	@ManyToOne
	@JoinColumn(name= "idOficio", nullable=false)
	private Oficio oficio;
	
	private int tiempo_experiencia;

	public TrabajadorOficio() {
		super();
	}

	public TrabajadorOficio(int idTrabajadorOficio, Trabajador trabajador, Oficio oficio, int tiempo_experiencia) {
		super();
		this.idTrabajadorOficio = idTrabajadorOficio;
		this.trabajador = trabajador;
		this.oficio = oficio;
		this.tiempo_experiencia = tiempo_experiencia;
	}

	public int getIdTrabajadorOficio() {
		return idTrabajadorOficio;
	}

	public void setIdTrabajadorOficio(int idTrabajadorOficio) {
		this.idTrabajadorOficio = idTrabajadorOficio;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Oficio getOficio() {
		return oficio;
	}

	public void setOficio(Oficio oficio) {
		this.oficio = oficio;
	}

	public int getTiempo_experiencia() {
		return tiempo_experiencia;
	}

	public void setTiempo_experiencia(int tiempo_experiencia) {
		this.tiempo_experiencia = tiempo_experiencia;
	}

}
