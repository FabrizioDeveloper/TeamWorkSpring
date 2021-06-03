package pe.edu.upc.model;

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
@Table(name="solicitatrabajador")
public class SolicitaTrabajador implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSolicitaTrabajador;
	
	@ManyToOne
	@JoinColumn(name= "idTrabajador", nullable=false)
	private Trabajador trabajador;
	
	@ManyToOne
	@JoinColumn(name= "idCliente", nullable=false)
	private Cliente cliente;
	
	private Date fecha;
	
	private Date hora;
	
	@Column(name="direccion", nullable=false, length=40)
	private String direccion;
	
	@Column(name="descripcionServicio", nullable=false, length=50)
	private String descripcionServicio;
	
	@ManyToOne
	@JoinColumn(name= "idTipoPago", nullable=false)
	private TipoPago tipopago;

	@Column(name="estado", nullable=false, length=5)
	private String estado;

	public SolicitaTrabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SolicitaTrabajador(int idSolicitaTrabajador, Trabajador trabajador, Cliente cliente, Date fecha, Date hora,
			String direccion, String descripcionServicio, TipoPago tipopago, String estado) {
		super();
		this.idSolicitaTrabajador = idSolicitaTrabajador;
		this.trabajador = trabajador;
		this.cliente = cliente;
		this.fecha = fecha;
		this.hora = hora;
		this.direccion = direccion;
		this.descripcionServicio = descripcionServicio;
		this.tipopago = tipopago;
		this.estado = estado;
	}

	public int getIdSolicitaTrabajador() {
		return idSolicitaTrabajador;
	}

	public void setIdSolicitaTrabajador(int idSolicitaTrabajador) {
		this.idSolicitaTrabajador = idSolicitaTrabajador;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDescripcionServicio() {
		return descripcionServicio;
	}

	public void setDescripcionServicio(String descripcionServicio) {
		this.descripcionServicio = descripcionServicio;
	}

	public TipoPago getTipopago() {
		return tipopago;
	}

	public void setTipopago(TipoPago tipopago) {
		this.tipopago = tipopago;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
