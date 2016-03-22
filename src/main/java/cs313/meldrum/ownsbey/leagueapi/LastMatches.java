/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.leagueapi;

import java.util.List;

/**
 *
 * @author Jake
 */
public class LastMatches {    
    private String summoner;
    private List<Match> matches;
    private float averageKills;
    private float averageDeaths;
    private float averageAssists;
    private float averageCreepScore;
    private float averageTotalGold;
    
    // MUST provide a Match array of the last 10 matches
    public LastMatches(String summoner, List<Match> matches) {
        setSummoner(summoner);
        setMatches(matches);
        int totalMatches = matches.size();
        float averageNum;
        //average kills
        averageNum = 0;
        for(Match match : matches){
            averageNum += match.getKills();
        }
        averageNum /= totalMatches;
        setAverageKills(averageNum);
        
        //average deaths
        averageNum = 0;
        for(Match match : matches){
            averageNum += match.getDeaths();
        }
        averageNum /= totalMatches;
        setAverageDeaths(averageNum);
        
        //average assists
        averageNum = 0;
        for(Match match : matches){
            averageNum += match.getAssists();
        }
        averageNum /= totalMatches;
        setAverageAssists(averageNum);
        
        //average creep score
        averageNum = 0;
        for(Match match : matches){
            averageNum += match.getCreepScore();
        }
        averageNum /= totalMatches;
        setAverageCreepScore(averageNum);
        
        //average total gold
        averageNum = 0;
        for(Match match : matches){
            averageNum += match.getTotalGold();
        }
        averageNum /= totalMatches;
        setAverageTotalGold(averageNum);
    }
    
    public String  getSummoner()          { return summoner; }
    public List<Match> getMatches()           { return matches; }
    public float   getAverageKills()      { return averageKills; }
    public float   getAverageDeaths()     { return averageDeaths; }
    public float   getAverageAssists()    { return averageAssists; }
    public float   getAverageCreepScore() { return averageCreepScore; }
    public float   averageTotalGold()     { return averageTotalGold; }
    
    private void setSummoner(String summoner) {
        this.summoner = summoner; 
    }
    private void setMatches(List<Match> matches) { 
        this.matches = matches; 
    }
    private void setAverageKills(float averageKills) { 
        this.averageKills = averageKills; 
    }
    private void setAverageDeaths(float averageDeaths) { 
        this.averageDeaths = averageDeaths; 
    }
    private void setAverageAssists(float averageAssists) { 
        this.averageAssists = averageAssists; 
    }
    private void setAverageCreepScore(float averageCreepScore) { 
        this.averageCreepScore = averageCreepScore; 
    }
    private void setAverageTotalGold(float averageTotalGold) {
        this.averageTotalGold = averageTotalGold; 
    }
}
