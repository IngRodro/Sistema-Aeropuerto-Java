package com.unab.edu.SistemaAeropuero.app.Entidad;

import java.io.Serializable;

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
@Table(name= "escala")
public class Escala implements Serializable{
	
	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idescala")
	private long idEscala;
	private long numeroEscala;
	private long idAeropuerto;
	private long nPasajerosSuben;
	private long nPasadoresBajan;
	@ManyToOne
	@JoinColumn(name = "iditinerario")
	private Itinerario idItinerario;
	
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
	public Itinerario getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(Itinerario idItinerario) {
		this.idItinerario = idItinerario;
	}
	
	
}
