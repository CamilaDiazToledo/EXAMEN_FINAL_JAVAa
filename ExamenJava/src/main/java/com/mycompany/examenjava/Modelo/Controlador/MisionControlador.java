/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examenjava.Modelo.Controlador;

/**
 *
 * @author camper
 */
import com.mycompany.examenjava.Modelo.Clases.algo.Estado;
import com.mycompany.examenjava.Modelo.Clases.algo.Mision;
import com.mycompany.examenjava.Modelo.Clases.algo.Rango;
import com.mycompany.examenjava.Modelo.Persistencia.CRUD;
import com.mycompany.examenjava.Modelo.Persistencia.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
        
        
public class MisionControlador {
    public static boolean createMision(String nombre, String descripcion, double recompensa, Estado estado, Rango rangoId){
    
        
        Mision a1 = new Mision(nombre, descripcion, recompensa, estado, rangoId);
        
        CRUD.setConnection(Conexion.getConexion());
        
        String insercion = 
                "INSERT INTO Mision "
                + "(nombre,descripcion,recompensa,estado,rangoId)"
                + "VALUES (?, ?, ?, ?, ?)";
    
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
    
    
    
    public static boolean deleteMision(int misionId) throws SQLException{
        
        CRUD.setConnection(Conexion.getConexion());
        String delete = "DELETE FROM Mision WHERE misionId = ?";
        
        List<Object> parameters = Arrays.asList(misionId);
        
        try{
            if(CRUD.setAutoCommitBD(false)){
                if(CRUD.borrarBD1(delete, parameters)){
                    System.out.println("fue eliminado exitosamente.");
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
    
    public static Mision getItem(int misionId) throws SQLException {
        
        Mision a1 = new Mision();
        CRUD.setConnection(Conexion.getConexion());
        
        String obtener = "SELECT * FROM Mision WHERE misionId = ?";
        List<Object> parametros = Arrays.asList(misionId);
        
        try {
            ResultSet rs = CRUD.consultarBD1(obtener, parametros);
            
            if(rs.next()){
                a1.setMisionId(rs.getInt("habilidadId"));
                a1.setNombre(rs.getString("nombre"));
                a1.setDescripcion(rs.getString("descripcion"));
                a1.setRecompensa(rs.getDouble("recompensa"));
                a1.setEstado(rs.getBoolean("estadoId"));
          
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
    
    
        
    
}

