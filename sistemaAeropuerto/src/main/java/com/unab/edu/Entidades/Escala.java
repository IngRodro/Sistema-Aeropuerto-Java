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
public class Escala extends Aeropuerto{
    private int idEscala;
    private int numeroEscala;
    private int nPasajerosSuben;
    private int npasajerosBajan;
    private int idItinerario;
    private double Precio;
}
