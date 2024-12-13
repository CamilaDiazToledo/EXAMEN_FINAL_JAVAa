/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class Habilidad {
    private int habilidadId;
    private String nombre;
    private String descripcion;

    public Habilidad() {
    }

    public Habilidad(int habilidadId) {
        this.habilidadId = habilidadId;
    }

    public Habilidad(int habilidadId, String descripcion) {
        this.habilidadId = habilidadId;
        this.descripcion = descripcion;
    }

    public Habilidad(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    

    public Habilidad(int habilidadId, String nombre, String descripcion) {
        this.habilidadId = habilidadId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(int habilidadId) {
        this.habilidadId = habilidadId;
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

    
    
    
    
}
