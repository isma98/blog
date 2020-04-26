/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ismael
 */
public class connection {
    public static Connection con(){
        String host = "localhost:3306", user ="root";
        String password ="Ismael2578";
        String bd="blog";
       
        
        String cadenaconexion;
        cadenaconexion ="jdbc:mysql://"+host+"/"+bd+"?useSSL=false&useTimezone=true&serverTimezone=GMT-5";
        Connection con = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(cadenaconexion, user, password);
            return con;
        }
        catch(ClassNotFoundException | SQLException e){
        	System.out.println("Error al Conectar a " + bd);
        	System.out.println("Error: " + e.toString());
            return null;
        }
    }
}
