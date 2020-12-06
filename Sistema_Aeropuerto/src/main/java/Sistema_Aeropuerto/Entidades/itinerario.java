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
@Table(name= "itinerario ")
public class itinerario  implements Serializable{

	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idItinerarios;
	private long idAeropuertoDestino;
	private long idAeropuertoOrigen;
	
	public long getIdItinerarios()
	
	{
		return idItinerarios;
	}
	public void setIdItinerarios(long idItinerarios) {
		this.idItinerarios = idItinerarios;
	}
	public long getIdAeropuertoDestino() {
		return idAeropuertoDestino;
	}
	public void setIdAeropuertoDestino(long idAeropuertoDestino) {
		this.idAeropuertoDestino = idAeropuertoDestino;
	}
	public long getIdAeropuertoOrigen() {
		return idAeropuertoOrigen;
	}
	public void setIdAeropuertoOrigen(long idAeropuertoOrigen) {
		this.idAeropuertoOrigen = idAeropuertoOrigen;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
