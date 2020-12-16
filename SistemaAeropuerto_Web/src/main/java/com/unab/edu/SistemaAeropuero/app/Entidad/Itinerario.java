package com.unab.edu.SistemaAeropuero.app.Entidad;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "itinerario ")
public class Itinerario implements Serializable{
	
	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "iditinerario")
	private long idItinerario;
	private Aeropuerto idAeropuertoDestino;
	@ManyToOne
	@JoinColumn(name = "idaeropuerto")
	private Aeropuerto idAeropuertoOrigen;
	private Date fecha;
	private String hora;
	private String Minutos;
	
	public long getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(long idItinerario) {
		this.idItinerario = idItinerario;
	}
	public Aeropuerto getIdAeropuertoDestino() {
		return idAeropuertoDestino;
	}
	public void setIdAeropuertoDestino(Aeropuerto idAeropuertoDestino) {
		this.idAeropuertoDestino = idAeropuertoDestino;
	}
	public Aeropuerto getIdAeropuertoOrigen() {
		return idAeropuertoOrigen;
	}
	public void setIdAeropuertoOrigen(Aeropuerto idAeropuertoOrigen) {
		this.idAeropuertoOrigen = idAeropuertoOrigen;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getMinutos() {
		return Minutos;
	}
	public void setMinutos(String minutos) {
		Minutos = minutos;
	}
	
	
}
