/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class Mision {
    private int misionId;
    private String nombre;
    private String descripcion;
    private double recompensa;
    private Boolean estado;
    private Rango rangoId;

    public Mision() {
    }

    public Mision(int misionId) {
        this.misionId = misionId;
    }

    public Mision(String nombre, String descripcion, double recompensa, Estado estado, Rango rangoId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.estado = false;
        this.rangoId = rangoId;
    }
    
    

    public Mision(int misionId, String nombre, String descripcion, double recompensa, Estado estado, Rango rangoId) {
        this.misionId = misionId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.recompensa = recompensa;
        this.estado = false;
        this.rangoId = rangoId;
    }

    

    public int getMisionId() {
        return misionId;
    }

    public void setMisionId(int misionId) {
        this.misionId = misionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(double recompensa) {
        this.recompensa = recompensa;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    public int getRangodInt() { 
        return rangoId.getRangoId();
    }
    
    
    
}
