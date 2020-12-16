package com.unab.edu.SistemaAeropuero.app.Entidad;


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
@Table(name= "vuelos")
public class Vuelo {
	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVuelo;
	@ManyToOne()
	@JoinColumn(name = "idCompany")
	private Company idCompany;
	@ManyToOne()
	@JoinColumn(name = "idItinerario")
	private Itinerario idItinerario;
	@ManyToOne()
	@JoinColumn(name = "idAvion")
	private Avion idAvion;
	@ManyToOne()
	@JoinColumn(name = "idTipos_vuelo")
	private Tipos_vuelo idTiposvuelo;
	
	
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

	public Tipos_vuelo getIdTiposvuelo() {
		return idTiposvuelo;
	}

	public void setIdTiposvuelo(Tipos_vuelo idTiposvuelo) {
		this.idTiposvuelo = idTiposvuelo;
	}
	
}
