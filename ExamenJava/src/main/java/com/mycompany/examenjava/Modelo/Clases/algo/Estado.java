/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public enum Estado {
    INCOMPLETO,
    PROECESO,
    COMPLETADA;
            

    public static Estado chooseType(int chooseSize) {
        switch(chooseSize) {
            case 1: return Estado.INCOMPLETO;
            case 2: return Estado.PROECESO;
            case 3: return Estado.COMPLETADA;

            default: throw new IllegalArgumentException("Estado no válido");
        }
    }
    
}
