package com.programmingfree.springservice.utility;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;


public class DBUtility {
 private static Connection connection = null;

//    public static Connection getConnection() {
//        if (connection != null)
//            return connection;
//        else {
//            try {
//             Properties prop = new Properties();
//                InputStream inputStream = DBUtility.class.getClassLoader().getResourceAsStream("/config.properties");
//                prop.load(inputStream);
//                String driver = prop.getProperty("driver");
//                String url = prop.getProperty("url");
//                String user = prop.getProperty("user");
//                String password = prop.getProperty("password");
//                Class.forName(driver);
//                connection = DriverManager.getConnection(url, user, password);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return connection;
//        }
//
//    }
    
    public static Connection getConnection() {
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
            cn = DriverManager.getConnection("jdbc:mysql://127.7.165.2:3306/taskmanager", "admin4i94wLB", "3KE8mpVN6LZU");//en el tuyo debe ser "" quizas 	          
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Usuario No Conectado a la base de Datoss");

        }
        return cn;
    }
    
    

}