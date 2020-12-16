package com.unab.edu.SistemaAeropuero.app.Entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tipos_vuelo")
public class Tipos_vuelo implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idtipos_vuelo")
	private Long idTipos_vuelo;
	@Column(name = "tipo")
	private String Tipo;
	@Column(name = "porcentajedesc")
	private float PorcentajeDesc;
	
	public Long getIdTipos_vuelo() {
		return idTipos_vuelo;
	}
	public void setIdTipos_vuelo(Long idTipos_vuelo) {
		this.idTipos_vuelo = idTipos_vuelo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}
	public float getPorcentajeDesc() {
		return PorcentajeDesc;
	}
	public void setPorcentajeDesc(float porcentajeDesc) {
		PorcentajeDesc = porcentajeDesc;
	}
}
