/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

import java.time.LocalDate;

/**
 *
 * @author camper
 */
public class MisionNinja {
    private Ninja ninjaId;
    private Mision misionId;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public MisionNinja() {
    }

    public MisionNinja(Ninja ninjaId) {
        this.ninjaId = ninjaId;
        
    }

    public MisionNinja(Ninja ninjaId, Mision misionId, LocalDate fechaInicio, LocalDate fechaFin) {
        this.ninjaId = ninjaId;
        this.misionId = misionId;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Ninja getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(Ninja ninjaId) {
        this.ninjaId = ninjaId;
    }

    public Mision getMisionId() {
        return misionId;
    }

    public void setMisionId(Mision misionId) {
        this.misionId = misionId;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNinjaIdString() { 
        return ninjaId.getNinjaId(); 
    }
    
    public String setNinjaIdString(String employe_id) {
        return ninjaId.getNinjaId();
        
    } 
    
   public int getMisionIdInt() { 
        return misionId.getMisionId();
    }
    
    
}
    
    
    

