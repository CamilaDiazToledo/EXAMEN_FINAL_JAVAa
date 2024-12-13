/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class Aldea {
    private int aldeaId;
    private String nombre;
    private int poblacion;

    public Aldea() {
    }

    public Aldea(int aldeaId) {
        this.aldeaId = aldeaId;
    }

    public Aldea(int aldeaId, int poblacion) {
        this.aldeaId = aldeaId;
        this.poblacion = poblacion;
    }

    public Aldea(String nombre, int poblacion) {
        this.nombre = nombre;
        this.poblacion = poblacion;
    }
    
    

    public Aldea(int aldeaId, String nombre, int poblacion) {
        this.aldeaId = aldeaId;
        this.nombre = nombre;
        this.poblacion = poblacion;
    }

    public int getAldeaId() {
        return aldeaId;
    }

    public void setAldeaId(int aldeaId) {
        this.aldeaId = aldeaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(int poblacion) {
        this.poblacion = poblacion;
    }

    
    
    
    
}
