package com.unab.edu.SistemaAeropuero.app.Entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "vuelo")
public class Vuelo {
	public static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idvuelo")
	private Long idVuelo;
	@ManyToOne()
	@JoinColumn(name = "idcompany")
	private Company idCompany;
	@ManyToOne()
	@JoinColumn(name = "iditinerario")
	private Itinerario idItinerario;
	@ManyToOne()
	@JoinColumn(name = "idavion")
	private Avion idAvion;
	private long estado;

	public static Long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(Long idVuelo) {
		this.idVuelo = idVuelo;
	}

	public Company getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Company idCompany) {
		this.idCompany = idCompany;
	}

	public Itinerario getIdItinerario() {
		return idItinerario;
	}

	public void setIdItinerario(Itinerario idItinerario) {
		this.idItinerario = idItinerario;
	}

	public Avion getIdAvion() {
		return idAvion;
	}

	public void setIdAvion(Avion idAvion) {
		this.idAvion = idAvion;
	}

	public long getEstado() {
		return estado;
	}

	public void setEstado(long estado) {
		this.estado = estado;
	}
	

}
