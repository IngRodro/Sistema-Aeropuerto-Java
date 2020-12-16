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
@Table(name= "promociones ")
public class Promociones implements Serializable{
	public static final long serialVersionUID=1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idpromocionesvuelos")
	private Long idPromocionesvuelos;
	@ManyToOne
	@JoinColumn(name = "idvuelo")
	private Vuelo idVuelo;
	private float descuento;
	
	public Long getIdPromocionesvuelos() {
		return idPromocionesvuelos;
	}
	public void setIdPromocionesvuelos(Long idPromocionesvuelos) {
		this.idPromocionesvuelos = idPromocionesvuelos;
	}
	public Vuelo getIdVuelo() {
		return idVuelo;
	}
	public void setIdVuelo(Vuelo idVuelo) {
		this.idVuelo = idVuelo;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	
}
