/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.Entidades;

import lombok.Data;

/**
 *
 * @author Usuario
 */
@Data
public class Usuario {
    private String nombreUsuario;
    private String nombres;
    private String apellidos;
    private int Edad;
    private String telefono;
    private String password;
    private int TipoUser;
}
