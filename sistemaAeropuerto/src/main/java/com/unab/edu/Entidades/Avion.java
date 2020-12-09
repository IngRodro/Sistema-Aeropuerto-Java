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
public class Avion {
    private int idAvion;
    private String modeloAvion;
    private int capacidad;
    String estado;
}
