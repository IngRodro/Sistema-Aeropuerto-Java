/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.Data;

/**
 *
 * @author Milton
 */
@Data
public class Pasaje {
    private int idPasaje;
    private int idPasajero;
    private int idVuelo;
    private int idClase;
    private int NAsiento;
    private String nombreUsuario;
    private float precionTotal;
    private int NEscala;

 
}
