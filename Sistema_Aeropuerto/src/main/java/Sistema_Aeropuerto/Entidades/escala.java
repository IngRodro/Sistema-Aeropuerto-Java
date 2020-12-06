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
@Table(name= "escala")
public class escala implements Serializable{

	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idEscala;
	private long numeroEscala;
	private long idAeropuerto;
	private long nPasajerosSuben;
	private long nPasadoresBajan;
	private long idItinerario;
	
	public long getIdEscala() 
	{
		return idEscala;
	}
	public void setIdEscala(long idEscala) {
		this.idEscala = idEscala;
	}
	public long getNumeroEscala() {
		return numeroEscala;
	}
	public void setNumeroEscala(long numeroEscala) {
		this.numeroEscala = numeroEscala;
	}
	public long getIdAeropuerto() {
		return idAeropuerto;
	}
	public void setIdAeropuerto(long idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public long getnPasajerosSuben() {
		return nPasajerosSuben;
	}
	public void setnPasajerosSuben(long nPasajerosSuben) {
		this.nPasajerosSuben = nPasajerosSuben;
	}
	public long getnPasadoresBajan() {
		return nPasadoresBajan;
	}
	public void setnPasadoresBajan(long nPasadoresBajan) {
		this.nPasadoresBajan = nPasadoresBajan;
	}
	public long getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(long idItinerario) {
		this.idItinerario = idItinerario;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
