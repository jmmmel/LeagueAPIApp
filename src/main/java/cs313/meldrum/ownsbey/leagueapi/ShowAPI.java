/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.meldrum.ownsbey.leagueapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import cs313.meldrum.ownsbey.LeagueInteraction.LeagueInteraction;
import cs313.meldrum.ownsbey.db.dbHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author James
 */
@WebServlet(name = "ShowAPI", urlPatterns = {"/ShowAPI"})
public class ShowAPI extends HttpServlet {
   
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            String summonerName;
            summonerName = (String)session.getAttribute("currentSummoner");
            LeagueInteraction comms = new LeagueInteraction();
            Map<String, Object> map = comms.GetRecentGames(summonerName);
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
            LastMatches matchHistory = new LastMatches(summonerName,matchCollection);
            dbHandler db = new dbHandler();
            db.updateMatchHistory(matchHistory);
            request.setAttribute("alldata", map.toString());
            request.getRequestDispatcher("Main.jsp").forward(request, response);
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
