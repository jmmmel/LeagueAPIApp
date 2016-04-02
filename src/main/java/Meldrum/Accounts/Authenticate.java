/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Meldrum.Accounts;

import cs313.meldrum.ownsbey.LeagueInteraction.LeagueInteraction;
import cs313.meldrum.ownsbey.db.dbHandler;
import cs313.meldrum.ownsbey.leagueapi.LastMatches;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
@WebServlet(name = "Authenticate", urlPatterns = {"/Authenticate"})
public class Authenticate extends HttpServlet {

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
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        dbHandler db = new dbHandler();
        String summonerName = db.getValidUser(userName, password);
        
        if (summonerName != null)
        {
            LeagueInteraction li = new LeagueInteraction();
            List<String> followList;
            LastMatches matchHistory;
            
            matchHistory = li.GetRecentGames(summonerName);
            followList = db.getFollowList(summonerName);
            
            if(followList == null){
                followList = new ArrayList<>();
            }
            Map<String, LastMatches> favoritesStats = new HashMap<>();
            for(String favorite: followList){
                LastMatches favoriteHistory = li.GetRecentGames(favorite);
                favoritesStats.put(favorite, favoriteHistory);
            }
                     
            session.setAttribute("currentUser", userName);
            session.setAttribute("currentSummoner", summonerName);
            
            session.setAttribute("matchHistory", matchHistory);
            session.setAttribute("followList", favoritesStats);
            request.getRequestDispatcher("MainPage").forward(request, response);
        }
        else
        {
            session.setAttribute("signedIn", false);
            request.setAttribute("errorSignIn", true);
            request.getRequestDispatcher("SignIn.jsp").forward(request, response);
        }
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
