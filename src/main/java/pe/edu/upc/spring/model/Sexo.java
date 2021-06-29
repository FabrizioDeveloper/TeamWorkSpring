package pe.edu.upc.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sexo")
public class Sexo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idSexo;
	
	private String tipoSexo;

	public int getIdSexo() {
		return idSexo;
	}

	public void setIdSexo(int idSexo) {
		this.idSexo = idSexo;
	}

	public String getTipoSexo() {
		return tipoSexo;
	}

	public void setTipoSexo(String tipoSexo) {
		this.tipoSexo = tipoSexo;
	}

}
