/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class Ninja {
    private String ninjaId;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private Rango rangoId;
    private Aldea aldeaId;

    public Ninja() {
    }

    public Ninja(String ninjaId) {
        this.ninjaId = ninjaId;
    }

    public Ninja(String ninjaId, String nombre, String telefono, String correo, String direccion, Rango rangoId, Aldea aldeaId) {
        this.ninjaId = ninjaId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.rangoId = rangoId;
        this.aldeaId = aldeaId;
    }

    public String getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(String ninjaId) {
        this.ninjaId = ninjaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Rango getRangoId() {
        return rangoId;
    }

    public void setRangoId(Rango rangoId) {
        this.rangoId = rangoId;
    }

    public Aldea getAldeaId() {
        return aldeaId;
    }

    public void setAldeaId(Aldea aldeaId) {
        this.aldeaId = aldeaId;
    }
    
    public int getRangodInt() { 
        return rangoId.getRangoId();
    }
    
    public int getAldeaInt() { 
        return aldeaId.getAldeaId();
    }

    
    
    
    
    
}
