/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Karen
 */
public class MensajesDAO {
      
    public static void crearMensaje(Mensajes mensaje)
    {
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje,autor_mensaje) VALUES (?,?) ";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Correctamente ingresado");
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
    
    public static void leerMensaje()
    {
        Conexion db_connect = new Conexion();
         PreparedStatement ps = null;
         ResultSet rs = null;
        try(Connection conexion = db_connect.get_connection()) {
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next())
            {
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje:" + rs.getString("mensaje"));
                System.out.println("Autor:" + rs.getString("autor_mensaje"));
                System.out.println("Fecha:" + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        } catch(SQLException e) {
            System.out.println("Error" + e);
        }
    }
    
    public static void borrarMensaje(int id_mensaje)
    {
        Conexion db_connect = new Conexion();
        
            try (Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
             try {
                 String query;
                 query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                 ps = conexion.prepareStatement(query);
                 ps.setInt(1, id_mensaje);
                 ps.executeUpdate();
                 System.out.println("Eliminando correctamente");
             } catch (SQLException e) {
                 System.out.println("Error" + e);
             }
        } catch (SQLException e) {
             System.out.println("Error" + e);
        }
    }
    
    public static void actualizarMensaje(Mensajes mensaje)
    {
         Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connection()){
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?;";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();                
                System.out.println("Correctamente actualizado");
            } catch (SQLException e) {
                System.out.println("Error" + e);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }        
    }
}
