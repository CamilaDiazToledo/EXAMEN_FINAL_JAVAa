/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Controlador;

import com.mycompany.examenjava.Modelo.Clases.algo.Rango;
import com.mycompany.examenjava.Modelo.Persistencia.CRUD;
import com.mycompany.examenjava.Modelo.Persistencia.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/**
 *
 * @author camper
 */
public class RangoControlador {
    //Crate 
    
    public static boolean createRango(String nombre){
    
        
        Rango a1 = new Rango(nombre);
        
        CRUD.setConnection(Conexion.getConexion());
        
        String insercion = 
                "INSERT INTO Rango "
                + "(nombre)"
                + "VALUES (?)";
    
        List<Object> parametros = Arrays.asList(
                a1.getNombre());
                
        try{
            if(CRUD.setAutoCommitBD(false)){
                if(CRUD.insertarBD1(insercion, parametros)){
                    System.out.println("Registro exitoso!!");
                        CRUD.commitBD();
                        return true;
                } else {
                    System.out.println("Error al registrar la habilidad");
                    CRUD.rollbackBD();  
                }
            }
        }catch (Exception ex) {
            System.out.println("Error en la transacción: " + ex.getMessage());
            CRUD.rollbackBD();
            throw ex;
        } finally {
            CRUD.setAutoCommitBD(true);
            CRUD.cerrarConexion(); 
        }
        return false;
    }
    
    
    
    public static boolean deleteRango(int habilidadId) throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        String delete = "DELETE FROM Habilidad WHERE habilidadId = ?";
        
        List<Object> parameters = Arrays.asList(habilidadId);
        
        try{
            if(CRUD.setAutoCommitBD(false)){
                if(CRUD.borrarBD1(delete, parameters)){
                    System.out.println("La aldeafue eliminado exitosamente.");
                    CRUD.commitBD(); 
                    return true;
                }else{
                    System.out.println("Error al eliminar .");
                    CRUD.rollbackBD(); 
                }
            }
        }catch (Exception ex) {
            System.out.println("Error en la transacción: " + ex.getMessage());
            CRUD.rollbackBD(); 
            throw ex; 
        } finally {
            
            CRUD.setAutoCommitBD(true);
            CRUD.cerrarConexion();
        }
        return false;
    
    }
    
    public static Rango getRango(int rangoId) throws SQLException {
        
        Rango a1 = new Rango();
        CRUD.setConnection(Conexion.getConexion());
        
        String obtener = "SELECT * FROM Rango WHERE rangoId = ?";
        List<Object> parametros = Arrays.asList(rangoId);
        
        try {
            ResultSet rs = CRUD.consultarBD1(obtener, parametros);
            
            if(rs.next()){
                
                a1.setNombre(rs.getString("nombre"));
                
          
            }
            rs.close();  
            
        }catch (SQLException ex) {
            System.out.println("Error al obtener  " + ex.getMessage());
            throw ex; 
        } finally {
            
            CRUD.cerrarConexion();
        }

        return a1;
    }
    
    public static List<Rango> getRangoList() throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        List<Rango> inventoryList = new ArrayList<>();
        
        try{
            String obtener = "SELECT * FROM Rango";
            ResultSet rs = CRUD.consultarBD1(obtener, new ArrayList<>());
            while(rs.next()){
                Rango a1 = new Rango();

                a1.setNombre(rs.getString("nombre"));

                
                inventoryList.add(a1);  
            }
        }catch (SQLException ex) {
            System.out.println("Error al obtener la lista : " + ex.getMessage());
            throw ex; 
        } finally {
            
            CRUD.cerrarConexion();
        }
        return inventoryList;
    }
    
    public static void showRangoList(){
        try{
            CRUD.setConnection(Conexion.getConexion());
            List<Rango> rango = getRangoList();
            System.out.println("~~~~~~~~~~~~~ LISTA DE RANGOS ~~~~~~~~~~~~~");
            for(Rango a1 : rango){
                System.out.println("nombre: " + a1.getNombre());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            CRUD.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al obtener : " + e.getMessage());
            CRUD.cerrarConexion();
        }
        
    }
}
