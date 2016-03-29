/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.LeagueInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs313.meldrum.ownsbey.db.dbHandler;
import cs313.meldrum.ownsbey.leagueapi.LastMatches;
import cs313.meldrum.ownsbey.leagueapi.Match;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class LeagueInteraction {    
    
    
    private String SUMMONER_DETAILS_NAME = "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/%s?api_key=";
    private String FREE_TO_PLAY = "https://na.api.pvp.net/api/lol/na/champion?freeToPlay=true&api_key=";
    private String CHAMP_DETAILS = "https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion/%s?api_key=";
    private String RECENT_HISTORY = "https://na.api.pvp.net/api/lol/na/v1.3/game/by-summoner/%s/recent?api_key=";
    
    public LeagueInteraction(){
       Properties prop = new Properties();
       ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
       InputStream in = classLoader.getResourceAsStream("apiProperties.properties");
       
        try {
            prop.load(in);
            in.close();
        } catch (IOException ex) {
            Logger.getLogger(LeagueInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }

        String key = (String)prop.get("api_key");
        SUMMONER_DETAILS_NAME += key;
        FREE_TO_PLAY += key;
        CHAMP_DETAILS += key;
        RECENT_HISTORY += key;
        
    }
    public LastMatches GetRecentGames(String summonerName){
        LastMatches results = null;
        try {
            dbHandler db = new dbHandler();
            results = db.getMatchHistory(summonerName);
            if (results == null || results.needsUpdated()){
                String formattedString = String.format(SUMMONER_DETAILS_NAME, summonerName);
                URL url = new URL(formattedString);
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> map = mapper.readValue(url, Map.class);
                Map<String, Object> test = (Map<String, Object>)map.get(summonerName.toLowerCase());
                System.out.println(test.toString());
                String id = test.get("id").toString();
                formattedString = String.format(RECENT_HISTORY, id);
                url = new URL(formattedString);
                map = mapper.readValue(url, Map.class);
                List<Match> matchCollection = new ArrayList<Match>();
                List<LinkedHashMap<String, Object>> games = (ArrayList<LinkedHashMap<String, Object>>)map.get("games");
                for(LinkedHashMap<String, Object> game : games){
                    LinkedHashMap<String, Object> stats = (LinkedHashMap<String, Object>)game.get("stats");
                    int userId = 1;
                    Integer kills = (Integer)stats.get("championsKilled");
                    Integer deaths = (Integer)stats.get("numDeaths");
                    Integer assists = (Integer)stats.get("assists");
                    Integer creepScore = (Integer)stats.get("minionsKilled");
                    Integer gold = (Integer)stats.get("goldEarned");
                    if(kills == null){ kills = 0;}
                    if(deaths == null){ deaths = 0;}
                    if(assists == null){ assists = 0;}
                    if(creepScore == null){ creepScore = 0;}
                    if(gold == null){ gold = 0;}
                    matchCollection.add(new Match(kills,deaths,assists,creepScore,gold));
                }
                results = new LastMatches(summonerName, matchCollection, new Date());
                db.updateMatchHistory(results);
            } 
            
        } catch (Exception ex) {
            Logger.getLogger(LeagueInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return results;
    }
}
