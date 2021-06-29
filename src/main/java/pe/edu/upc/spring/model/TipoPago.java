package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipopago")
public class TipoPago implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTipoPago;
	
	@Column(name="nombreTipoPago", nullable=false, length=10)
	private String nombreTipoPago;

	public int getIdTipoPago() {
		return idTipoPago;
	}

	public void setIdTipoPago(int idTipoPago) {
		this.idTipoPago = idTipoPago;
	}

	public String getNombreTipoPago() {
		return nombreTipoPago;
	}

	public void setNombreTipoPago(String nombreTipoPago) {
		this.nombreTipoPago = nombreTipoPago;
	}

}
