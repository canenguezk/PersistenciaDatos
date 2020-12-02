/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.platzi.mensajes.app;

import java.util.Scanner;

/**
 *
 * @author Karen
 */
public class MensajesServices {
    
    public static void crearMensaje()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe el Autor");
        String nombre = sc.nextLine();
        
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensaje(registro);        
    }
    
    public static void listarMensaje()
    {
        MensajesDAO.leerMensaje();
    }
    
    public static void borrarMensaje()
    {
       Scanner sc = new Scanner(System.in);
        System.out.println("Indica el ID al mensaje a borrar");
        int id_mensaje = sc.nextInt();
        MensajesDAO.borrarMensaje(id_mensaje);
    }
    public static void editarMensaje()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica tu nuevo mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Indica el ID del mensaje a ctualizar");
        int id_mensaje = sc.nextInt();
        Mensajes actualizacion = new Mensajes();
        actualizacion.setId_mensaje(id_mensaje);
        actualizacion.setMensaje(mensaje);
        MensajesDAO.actualizarMensaje(actualizacion);        
    }
    
}
