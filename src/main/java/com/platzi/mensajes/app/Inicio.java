/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes.app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author Karen
 */
public class Inicio {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do
        {
            System.out.println("-----------------------");
            System.out.println(" Aplicación de Mensaje");
            System.out.println("1. Crear un Mensaje");
            System.out.println("2. Listar un Mensaje");
            System.out.println("3. Eliminar un Mensaje");
            System.out.println("4. Editar Mensaje");
            System.out.println("5. Salir");        
            //Leemos la opcion del usuario
            opcion = sc.nextInt();
            
            switch(opcion)
            {
                case 1:
                    MensajesServices.crearMensaje();
                    break;
                case 2: 
                    MensajesServices.listarMensaje();
                    break;
                case 3:
                    MensajesServices.borrarMensaje();
                    break;
                case 4:
                    MensajesServices.editarMensaje();
                    break;                    
                default:
                    break;
            }
            
        }while(opcion != 5);
        
        /*Conexion cn = new Conexion();
        try(Connection cnx = cn.get_connection()){            
        } catch (Exception e) {
            System.out.println(e);
        }*/
    }
    
}
