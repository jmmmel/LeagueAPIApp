<%-- 
    Document   : index
    Created on : Mar 25, 2016, 11:18:24 PM
    Author     : James
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>League API</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <h1>Welcome back, ${sessionScope.currentUser}</h1><br>
        <table class="mainTable">
            <tr>
                <td class="mainTableTD">
                    Summoner name: ${sessionScope.currentSummoner}<br>
                    <br>
                </td>
                <td class="mainTableTD">
                    Average kills: <div>${matchHistory.averageKills}</div>
                    Average deaths: <div>${matchHistory.averageDeaths}</div>
                    Average assists: <div>${matchHistory.averageAssists}</div>
                    Average creep score: <div>${matchHistory.averageCreepScore}</div>
                    Average gold: <div>${matchHistory.averageTotalGold}</div>
                </td>
            </tr>
            <tr>
                <td class="mainTableTD">
                    <table class="leftSubTable">
                        <c:forEach items="${followList}" var="favorite"> 
                            <tr>
                                <td class="subTableTD">${favorite.key}</td>
                                <td class="subTableTD"><b>Average K/D/A: </b>
                                    ${favorite.value['averageKills']}/${favorite.value.averageDeaths}/${favorite.value.averageAssists} <br>
                                    <b>Average CS:</b> ${favorite.value.averageCreepScore} <b>Average Gold:</b> ${favorite.value.averageTotalGold}
                                </td>
                            </tr>
                        </c:forEach>
                        <form action="AddFavorite" method="POST">
                            <tr>
                                <td>
                                    New followed summoner name:
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" id="otherSummoner" name="otherSummoner">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="submit" value="Add Summoner">
                                </td>
                            </tr>
                        </form>
                    </table>
                </td>
                <td class="mainTableTD">
                    <table>
                        <c:forEach items="${matchHistory.matches}" var="match" varStatus="count">
                            <tr>
                                <td class="subTableTD">Match ${count.index}:</td>
                                <td class="subTableTD">
                                    <b>Kills/Deaths/Assists: </b>${match.kills}/${match.deaths}/${match.assists} <br>
                                    <b>CS:</b> ${match.creepScore} <b>Gold:</b> ${match.totalGold}
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </td>
            </tr>
        </table>
        
    </body>
</html>
