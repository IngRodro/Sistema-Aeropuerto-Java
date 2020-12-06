package Sistema_Aeropuerto.Entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "promociones ")
public class promociones  implements Serializable{

	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPromocionesvuelos;
	private long idVuelo;
	private float descuento;
	
	public long getIdPromocionesvuelos() {
		return idPromocionesvuelos;
	}
	public void setIdPromocionesvuelos(long idPromocionesvuelos) {
		this.idPromocionesvuelos = idPromocionesvuelos;
	}
	public long getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}