/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.LeagueInteraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URL;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class LeagueInteraction {
    private final String SUMMONER_DETAILS_NAME = "https://na.api.pvp.net/api/lol/na/v1.4/summoner/by-name/%s?api_key=629cfed4-d9cc-4a72-8b42-82d1291f4cc3";
    private final String FREE_TO_PLAY = "https://na.api.pvp.net/api/lol/na/champion?freeToPlay=true&api_key=629cfed4-d9cc-4a72-8b42-82d1291f4cc3";
    private final String CHAMP_DETAILS = "https://global.api.pvp.net/api/lol/static-data/na/v1.2/champion/%s?api_key=629cfed4-d9cc-4a72-8b42-82d1291f4cc3";
    private final String RECENT_HISTORY = "https://na.api.pvp.net/api/lol/na/v1.3/game/by-summoner/%s/recent?api_key=629cfed4-d9cc-4a72-8b42-82d1291f4cc3";
    
    public Map<String, Object> GetRecentGames(String summonerName){
        try {
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
            return map;
        } catch (Exception ex) {
            Logger.getLogger(LeagueInteraction.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
