/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class Rango {
    private int rangoId;
    private String nombre;

    public Rango() {
    }

    public Rango(int rangoId) {
        this.rangoId = rangoId;
    }

    public Rango(String nombre) {
        this.nombre = nombre;
    }
    

    public Rango(int rangoId, String nombre) {
        this.rangoId = rangoId;
        this.nombre = nombre;
    }

    public int getRangoId() {
        return rangoId;
    }

    public void setRangoId(int rangoId) {
        this.rangoId = rangoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
