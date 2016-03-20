/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.leagueapi;

/**
 *
 * @author Jake
 */
public class LastMatches {    
    private String summoner;
    private Match[] matches;
    private float averageKills;
    private float averageDeaths;
    private float averageAssists;
    private float averageCreepScore;
    private float averageTotalGold;
    
    // MUST provide a Match array of the last 10 matches
    public LastMatches(String summoner, Match[] matches) {
        setSummoner(summoner);
        setMatches(matches);
        
        float averageNum;
        //average kills
        averageNum = 0;
        for(int i = 0; i <= 10; ++i) {
            averageNum += matches[i].getKills();
        }
        averageNum /= 10;
        setAverageKills(averageNum);
        
        //average deaths
        averageNum = 0;
        for(int i = 0; i <= 10; ++i) {
            averageNum += matches[i].getDeaths();
        }
        averageNum /= 10;
        setAverageDeaths(averageNum);
        
        //average assists
        averageNum = 0;
        for(int i = 0; i <= 10; ++i) {
            averageNum += matches[i].getAssists();
        }
        averageNum /= 10;
        setAverageAssists(averageNum);
        
        //average creep score
        averageNum = 0;
        for(int i = 0; i <= 10; ++i) {
            averageNum += matches[i].getCreepScore();
        }
        averageNum /= 10;
        setAverageCreepScore(averageNum);
        
        //average total gold
        averageNum = 0;
        for(int i = 0; i <= 10; ++i) {
            averageNum += matches[i].getTotalGold();
        }
        averageNum /= 10;
        setAverageTotalGold(averageNum);
    }
    
    public String  getSummoner()          { return summoner; }
    public Match[] getMatches()           { return matches; }
    public float   getAverageKills()      { return averageKills; }
    public float   getAverageDeaths()     { return averageDeaths; }
    public float   getAverageAssists()    { return averageAssists; }
    public float   getAverageCreepScore() { return averageCreepScore; }
    public float   averageTotalGold()     { return averageTotalGold; }
    
    public void setSummoner(String summoner) {
        this.summoner = summoner; 
    }
    public void setMatches(Match[] matches) { 
        this.matches = matches; 
    }
    public void setAverageKills(float averageKills) { 
        this.averageKills = averageKills; 
    }
    public void setAverageDeaths(float averageDeaths) { 
        this.averageDeaths = averageDeaths; 
    }
    public void setAverageAssists(float averageAssists) { 
        this.averageAssists = averageAssists; 
    }
    public void setAverageCreepScore(float averageCreepScore) { 
        this.averageCreepScore = averageCreepScore; 
    }
    public void setAverageTotalGold(float averageTotalGold) {
        this.averageTotalGold = averageTotalGold; 
    }
}
