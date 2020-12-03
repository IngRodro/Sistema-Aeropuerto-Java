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
public class Pasajero {
    private int idPasajero;
    private String nombres;
    private String apellidos;
    private int edad;
    private String sexo;
    private String documentoIdentidad;
    private String pasaporte;
}
