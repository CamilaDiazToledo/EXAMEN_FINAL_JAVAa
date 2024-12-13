/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Clases.algo;

/**
 *
 * @author camper
 */
public class HabilidadNinja {
    private String habilidaNinjadId;
    private Ninja ninjaId;
    private Habilidad habilidadId;

    public HabilidadNinja() {
    }

    public HabilidadNinja(String habilidaNinjadId, Ninja ninjaId, Habilidad habilidadId) {
        this.habilidaNinjadId = habilidaNinjadId;
        this.ninjaId = ninjaId;
        this.habilidadId = habilidadId;
    }

    public String getHabilidaNinjadId() {
        return habilidaNinjadId;
    }

    public void setHabilidaNinjadId(String habilidaNinjadId) {
        this.habilidaNinjadId = habilidaNinjadId;
    }

    public Ninja getNinjaId() {
        return ninjaId;
    }

    public void setNinjaId(Ninja ninjaId) {
        this.ninjaId = ninjaId;
    }

    public Habilidad getHabilidadId() {
        return habilidadId;
    }

    public void setHabilidadId(Habilidad habilidadId) {
        this.habilidadId = habilidadId;
    }
    
    public String setNinjaIdString(String employe_id) {
        return ninjaId.getNinjaId();
        
    } 
    
    public int getHabilidadIdInt() { 
        return habilidadId.getHabilidadId();
    }
    
    
}
