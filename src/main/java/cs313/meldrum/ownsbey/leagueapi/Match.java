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
public class Match {
    private int kills;
    private int deaths;
    private int assists;
    private int creepScore;
    private int totalGold;
    
    public Match(int kills, int deaths, int assists, 
            int creepScore, int totalGold) {
        setKills(kills);
        setDeaths(deaths);
        setAssists(assists);
        setCreepScore(creepScore);
        setTotalGold(totalGold);
    }
    
    public int getKills()      { return kills; }
    public int getDeaths()     { return deaths; }
    public int getAssists()    { return assists; }
    public int getCreepScore() { return creepScore; }
    public int getTotalGold()  { return totalGold; }
    
    public void setKills     (int kills)      { this.kills = kills; }
    public void setDeaths    (int deaths)     { this.deaths = deaths; }
    public void setAssists   (int assists)    { this.assists = assists; }
    public void setCreepScore(int creepScore) { this.creepScore = creepScore; }
    public void setTotalGold (int totalGold)  { this.totalGold = totalGold; }
}
