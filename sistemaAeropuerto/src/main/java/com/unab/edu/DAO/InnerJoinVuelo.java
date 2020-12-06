/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import java.util.Date;
import lombok.Data;

/**
 *
 *
 */
@Data
public class InnerJoinVuelo {
    int Vuelo;
    String Company;
    String AeropuertoO;
    String AeropuertoD;
    String Modelo;
    String Tipo;
    Date Fecha;
    String hora;
    String minutos;
    Double Descuento;
}
