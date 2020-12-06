/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Milton
 */
@Data
public class Promociones {
    
    private int idPromociones;
    private Date FechaInicio;
    private Date FechaFinal;
    private Double Descuento;
    private int idVuelo;
    
            
}
