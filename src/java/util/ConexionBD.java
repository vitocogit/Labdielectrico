/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author pgcardenasg
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    
    private final String servidor = "164.77.92.62";
    //private final String servidor = "localhost";
    private final String bd = "s4";
    private final String usuario = "meditres";
    private final String password = "DDfeR4#$5\"!\"1\"°1°22";
    

    public Connection getConnection() {
        Connection cn = null;
        try {
            
            //PostgreSQL
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection("jdbc:postgresql://"+servidor+":5432/"+bd+"", ""+usuario+"", ""+password+"");
           
            System.out.println("Coneccion OK");
            
        } catch (ClassNotFoundException | SQLException e) {
            
           System.out.println("Coneccion Error");
        
        }
        return cn;
    }

}

