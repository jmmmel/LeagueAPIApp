/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.db;

import cs313.meldrum.ownsbey.LeagueInteraction.LeagueInteraction;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author James
 */
public class dbHandler {
    private String DB_URL;
    private Connection conn = null;
    private Statement stmt = null;
    
    public dbHandler(){    
        Properties prop = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream("dbProperties.properties");
        try {
            prop.load(in);
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(LeagueInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        String user = prop.getProperty("user");
        String password = prop.getProperty("password");
        DB_URL = prop.getProperty("db_url");
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
