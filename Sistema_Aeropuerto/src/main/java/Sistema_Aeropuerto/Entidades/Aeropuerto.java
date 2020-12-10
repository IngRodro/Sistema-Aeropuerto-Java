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
@Table(name= "aeropuerto")
public class Aeropuerto implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idAeropuerto;
	
	public long getIdAeropuerto()
	{
		return idAeropuerto;
	}
	public void setIdAeropuerto(long idAeropuerto) {
		this.idAeropuerto = idAeropuerto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public float getPresioEstimVuelo() {
		return PresioEstimVuelo;
	}
	public void setPresioEstimVuelo(float presioEstimVuelo) {
		PresioEstimVuelo = presioEstimVuelo;
	}
	private String nombre;
	private String pais;
	private String ciudad;
	private float PresioEstimVuelo;
	
}
