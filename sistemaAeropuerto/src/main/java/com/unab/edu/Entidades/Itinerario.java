/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author Milton
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Itinerario {
    private int idItinerario;
    private int idAeropuertoDestino;
    private int idAeropuertoOrigen;
    private int idEscala;
    private Date fecha;
    private String hora;
    private String minutos;
}
