/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.db;

import cs313.meldrum.ownsbey.LeagueInteraction.LeagueInteraction;
import cs313.meldrum.ownsbey.leagueapi.LastMatches;
import cs313.meldrum.ownsbey.leagueapi.Match;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private PreparedStatement  stmt = null;
    
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
    
    public String getValidUser(String username, String password){
        String summonerName = null;
        try {
            String hashPass = simpleMD5Hash.Hash(password);
            String query = "SELECT summonerName FROM users WHERE username=? AND password=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,username);
            stmt.setString(2,hashPass);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                summonerName = rs.getString("summonerName");
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return summonerName;        
    }
    
    public LastMatches getMatchHistory(String summonerName){
        LastMatches matchHistory = null;
        try {
            String query = "SELECT s.kills, s.deaths, s.assists, s.creepScore, s.gold, s.createdTime "
                    + "FROM statistics s "
                    + "JOIN users u ON u.id=s.userId "
                    + "WHERE u.summonerName=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1,summonerName);
            ResultSet rs = stmt.executeQuery();
            Date updateTime = null;
            List<Match> currMatches = new ArrayList<>();
            if(rs.next()){
                do {
                    updateTime = rs.getDate("createdTime");
                    currMatches.add(new Match(
                            rs.getInt("kills"), 
                            rs.getInt("deaths"), 
                            rs.getInt("assists"),
                            rs.getInt("creepScore"), 
                            rs.getInt("gold")));
                }while(rs.next());
                rs.close();
                stmt.close();
                matchHistory = new LastMatches(summonerName, currMatches, updateTime);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matchHistory;
    }
     public void updateMatchHistory(LastMatches matchHistory){
        int id = -1;
        try {
            String query = "DELETE FROM statistics "
                    + "WHERE summonerName=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, matchHistory.getSummoner());
            stmt.execute();
            stmt.close();
            
            for (Match game: matchHistory.getMatches()){
                query = "INSERT INTO `leagueapi`.`statistics`\n" +
                        "(`summonerName`,\n" +
                        "`kills`,\n" +
                        "`deaths`,\n" +
                        "`assists`,\n" +
                        "`creepScore`,\n" +
                        "`gold`,\n" +
                        "`createdTime`)\n" +
                        "VALUES\n" +
                        "(?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "?,\n" +
                        "NOW())";
                stmt = conn.prepareStatement(query);
                stmt.setString(1, matchHistory.getSummoner());
                stmt.setInt(2, game.getKills());
                stmt.setInt(3, game.getDeaths());
                stmt.setInt(4, game.getAssists());
                stmt.setInt(5, game.getCreepScore());
                stmt.setInt(6, game.getTotalGold());
                stmt.execute();            
                stmt.close();
            }            
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getFollowList(String summonerName) {
        List<String> favorites = null;
        try {            
            String query = "SELECT f.followedSummoner FROM favorites f JOIN users u ON u.id=f.userId WHERE u.summonerName=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, summonerName);
            ResultSet rs = stmt.executeQuery();
            favorites = new ArrayList<>();
            while(rs.next()){
                favorites.add(rs.getString("followedSummoner"));
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        return favorites;
    }
}
