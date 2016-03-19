/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author James
 */
public class dbHandler {
    final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost/leaguestats";
    private Connection conn = null;
    private Statement stmt = null;    
        // database credentials
        String user = "root";
        String password = "";
    dbHandler(){    
        
        
        try{
            // register driver
            Class.forName("com.mysql.jdbc.Driver");            
            // connect
            conn = DriverManager.getConnection(DB_URL, user, password);            
            
            
        } catch(Exception ex){
            System.out.println("CRITICAL FAILURE");
            System.out.println(ex);
        }
    }
}
