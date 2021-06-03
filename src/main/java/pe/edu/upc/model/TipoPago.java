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
@Table(name="TipoPago")
public class TipoPago extends Usuario implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idTipoPago;

	@OneToOne
	@JoinColumn(name = "idTipoPago", nullable= false)

	private int TipoPago;
  
  private string Nombreusuario;
  
  private float MontoPago;
  
  public int getTipoPago() {
		return TipoPago;
	}
  
	public int setTipoPago(int TipoPago) {
		this.TipoPago = TipoPago;
	}
  
  public string getNombreusuario(){
   return Nombreusuario;
  }
  
  public string setNombreusuario(String Nombreusuario){
   this.Nombreusuario = Nombreusuario;
  }
  
  public float getMontoPago(){
   return MontoPago;
  }
  
  public float setMontoPago(float MontoPago){
   this.MontoPago = MontoPago;
  }
}