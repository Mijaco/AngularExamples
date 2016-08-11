package com.conexion;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

    public static Connection obtenerConexion() {
        Connection cn = null;
        try {
//        	String host = "127.7.165.2";
//        	String port = "3306";

//        	String url = String.format("jdbc:mysql://%s:%s/cochera_lp4", host, port);
        	
            //cargar driver
//            Class.forName("com.mysql.jdbc.Driver");	// ESTE codigo jala del JAR.... es una clase con nombre "com.mysql...." ya esta definido 
            //conectar BD                          //la puerta de sql/nameBD/usuario, contrase�a
           
//            cn = DriverManager.getConnection(url);
//            cn = DriverManager.getConnection("https://aulafree-origenjuglar.rhcloud.com/phpmyadmin/cochera_lp4", "admin4i94wLB", "3KE8mpVN6LZU");//en el tuyo debe ser "" quizas 	          
       
            Class.forName("com.mysql.jdbc.Driver");	// ESTE codigo jala del JAR.... es una clase con nombre "com.mysql...." ya esta definido 
            //conectar BD                          //la puerta de sql/nameBD/usuario, contraseña
            cn = DriverManager.getConnection("jdbc:mysql://127.7.165.2:3306/cochera_lp4", "admin4i94wLB", "3KE8mpVN6LZU");//en el tuyo debe ser "" quizas 	          }
//            cn = DriverManager.getConnection("jdbc:mysql://localhost/cochera_lp4", "root", "mysql");//en el tuyo debe ser "" quizas
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuario No Conectado a la base de Datoss");

        }
        return cn;
    }
}