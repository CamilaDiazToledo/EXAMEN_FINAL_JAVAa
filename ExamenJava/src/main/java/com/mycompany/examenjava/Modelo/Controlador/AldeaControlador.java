/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Controlador;

import com.mycompany.examenjava.Modelo.Clases.algo.Aldea;
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
public class AldeaControlador {
    
    //Crate 
    
    public static boolean createAldea(String nombre, int poblacion){
    
        
        Aldea a1 = new Aldea(nombre, poblacion);
        
        CRUD.setConnection(Conexion.getConexion());
        
        String insercion = 
                "INSERT INTO Aldea "
                + "(nombre,poblacion)"
                + "VALUES (?, ?)";
    
        List<Object> parametros = Arrays.asList(
                a1.getNombre(),
                a1.getPoblacion());
                
        try{
            if(CRUD.setAutoCommitBD(false)){
                if(CRUD.insertarBD1(insercion, parametros)){
                    System.out.println("Registro exitoso!!");
                        CRUD.commitBD();
                        return true;
                } else {
                    System.out.println("Error al registrar la Aldea");
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
    
    //Update 
    
    public static boolean updateAldea(int aldeaId, int poblacion)throws SQLException{
        
        Aldea a1 = new Aldea(aldeaId, poblacion);
        
        CRUD.setConnection(Conexion.getConexion());
        String actualizacion = 
                "UPDATE Aldea SET poblacion = ? = ? WHERE aldeaId = ?";
        
        List<Object> parametros = Arrays.asList(
                a1.getPoblacion());
        
        try{
            if(CRUD.setAutoCommitBD(false)){
                
                if(CRUD.actualizarBD1(actualizacion, parametros)){
                    System.out.println("Actualizacion exitosa!!");
                    CRUD.commitBD();
                    return true;
                } else {
                    System.out.println("Error al actualizar la Aldea");
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
    
    public static boolean deleteAldea(int aldeaId) throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        String delete = "DELETE FROM Aldea WHERE aldeaId = ?";
        
        List<Object> parameters = Arrays.asList(aldeaId);
        
        try{
            if(CRUD.setAutoCommitBD(false)){
                if(CRUD.borrarBD1(delete, parameters)){
                    System.out.println("La aldeafue eliminado exitosamente.");
                    CRUD.commitBD(); 
                    return true;
                }else{
                    System.out.println("Error al eliminar aldea.");
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
    
    public static Aldea getAldea(int itemId) throws SQLException {
        
        Aldea a1 = new Aldea();
        CRUD.setConnection(Conexion.getConexion());
        
        String obtener = "SELECT * FROM Aldea WHERE aldeaId = ?";
        List<Object> parametros = Arrays.asList(itemId);
        
        try {
            ResultSet rs = CRUD.consultarBD1(obtener, parametros);
            
            if(rs.next()){
                a1.setAldeaId(rs.getInt("aldeaId"));
                a1.setNombre(rs.getString("nombre"));
                a1.setPoblacion(rs.getInt("poblacion"));
          
            }
            rs.close();  
            
        }catch (SQLException ex) {
            System.out.println("Error al obtener aldea " + ex.getMessage());
            throw ex; 
        } finally {
            
            CRUD.cerrarConexion();
        }

        return a1;
    }
    
    public static List<Aldea> getAldeaList() throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        List<Aldea> inventoryList = new ArrayList<>();
        
        try{
            String obtener = "SELECT * FROM Aldea";
            ResultSet rs = CRUD.consultarBD1(obtener, new ArrayList<>());
            while(rs.next()){
                Aldea a1 = new Aldea();
                a1.setAldeaId(rs.getInt("aldeaId"));
                a1.setNombre(rs.getString("nombre"));
                a1.setPoblacion(rs.getInt("poblacion"));
                
                inventoryList.add(a1);  
            }
        }catch (SQLException ex) {
            System.out.println("Error al obtener la lista de aldeas: " + ex.getMessage());
            throw ex; 
        } finally {
            
            CRUD.cerrarConexion();
        }
        return inventoryList;
    }
    
    public static void showAldeaList(){
        try{
            CRUD.setConnection(Conexion.getConexion());
            List<Aldea> aldea = getAldeaList();
            System.out.println("~~~~~~~~~~~~~ LISTA DE ALDEAS ~~~~~~~~~~~~~");
            for(Aldea a1 : aldea){
                System.out.println("aldeaId: " + a1.getAldeaId());
                System.out.println("nombre: " + a1.getNombre());
                System.out.println("poblacion: " + a1.getPoblacion());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            CRUD.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al obtener aldeas: " + e.getMessage());
            CRUD.cerrarConexion();
        }
        
    }
}

































