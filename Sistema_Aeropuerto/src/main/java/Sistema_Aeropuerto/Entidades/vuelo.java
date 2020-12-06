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
@Table(name= "vuelo")
public class vuelo implements Serializable{

	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVuelo;
	private long idCompany;
	private long idItinerario;
	private long idAvion;
	private long idTiposvuelo;
	private long capacidad;
	private float CostosExtras;
	public long getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(long idVuelo) {
		this.idVuelo = idVuelo;
	}
	public long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(long idCompany) {
		this.idCompany = idCompany;
	}
	public long getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(long idItinerario) {
		this.idItinerario = idItinerario;
	}
	public long getIdAvion() {
		return idAvion;
	}
	public void setIdAvion(long idAvion) {
		this.idAvion = idAvion;
	}
	public long getIdTiposvuelo() {
		return idTiposvuelo;
	}
	public void setIdTiposvuelo(long idTiposvuelo) {
		this.idTiposvuelo = idTiposvuelo;
	}
	public long getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(long capacidad) {
		this.capacidad = capacidad;
	}
	public float getCostosExtras() {
		return CostosExtras;
	}
	public void setCostosExtras(float costosExtras) {
		CostosExtras = costosExtras;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	}

