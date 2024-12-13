/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Controlador;

/**
 *
 * @author camper
 */
import com.mycompany.examenjava.Modelo.Clases.algo.Habilidad;
import com.mycompany.examenjava.Modelo.Persistencia.CRUD;
import com.mycompany.examenjava.Modelo.Persistencia.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class HabilidadControlador {
    //Crate 
    
    public static boolean createHabilidad(String nombre, String descripcion){
    
        
        Habilidad a1 = new Habilidad(nombre, descripcion);
        
        CRUD.setConnection(Conexion.getConexion());
        
        String insercion = 
                "INSERT INTO Habilidad "
                + "(nombre,descripcion)"
                + "VALUES (?, ?)";
    
        List<Object> parametros = Arrays.asList(
                a1.getNombre(),
                a1.getDescripcion());
                
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
    
    //Update 
    
    public static boolean updateHabilidad(int habilidadId, String descripcion)throws SQLException{
        
        Habilidad a1 = new Habilidad(habilidadId, descripcion);
        
        CRUD.setConnection(Conexion.getConexion());
        String actualizacion = 
                "UPDATE Habilidad SET descripcion = ? = ? WHERE habilidadId = ?";
        
        List<Object> parametros = Arrays.asList(
                a1.getDescripcion());
        
        try{
            if(CRUD.setAutoCommitBD(false)){
                
                if(CRUD.actualizarBD1(actualizacion, parametros)){
                    System.out.println("Actualizacion exitosa!!");
                    CRUD.commitBD();
                    return true;
                } else {
                    System.out.println("Error al actualizar ");
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
    
    public static boolean deleteHabilidad(int habilidadId) throws SQLException{
        
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
    
    public static Habilidad getItem(int itemId) throws SQLException {
        
        Habilidad a1 = new Habilidad();
        CRUD.setConnection(Conexion.getConexion());
        
        String obtener = "SELECT * FROM Habilidad WHERE habilidadId = ?";
        List<Object> parametros = Arrays.asList(itemId);
        
        try {
            ResultSet rs = CRUD.consultarBD1(obtener, parametros);
            
            if(rs.next()){
                a1.setHabilidadId(rs.getInt("habilidadId"));
                a1.setNombre(rs.getString("nombre"));
                a1.setDescripcion(rs.getString("descripcion"));
          
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
    
    public static List<Habilidad> getHabilidadList() throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        List<Habilidad> inventoryList = new ArrayList<>();
        
        try{
            String obtener = "SELECT * FROM Habilidad";
            ResultSet rs = CRUD.consultarBD1(obtener, new ArrayList<>());
            while(rs.next()){
                Habilidad a1 = new Habilidad();
                a1.setHabilidadId(rs.getInt("aldeaId"));
                a1.setNombre(rs.getString("nombre"));
                a1.setDescripcion(rs.getString("descripcion"));
                
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
    
    public static void showAldeaList(){
        try{
            CRUD.setConnection(Conexion.getConexion());
            List<Habilidad> habilidad = getHabilidadList();
            System.out.println("~~~~~~~~~~~~~ LISTA DE HABILIDADES ~~~~~~~~~~~~~");
            for(Habilidad a1 : habilidad){
                System.out.println("aldeaId: " + a1.getHabilidadId());
                System.out.println("nombre: " + a1.getNombre());
                System.out.println("poblacion: " + a1.getDescripcion());
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }
            CRUD.cerrarConexion();
        } catch (SQLException e) {
            System.out.println("Error al obtener : " + e.getMessage());
            CRUD.cerrarConexion();
        }
        
    }
}
