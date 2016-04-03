<%-- 
    Document   : compareSummoners
    Created on : Apr 2, 2016, 11:42:50 AM
    Author     : James
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comparison</title>
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <link rel='stylesheet' href='webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
    </head>
    <body>
        <row>
            <div class="col-lg-12">
                <h3 class="col-lg-5 col-md-5 col-sm-5">${main.summoner}</h3>
                <h4 class="col-lg-2 col-md-2 col-sm-2">Vs.</h4>
                <h3 class="col-lg-5 col-md-5 col-sm-5">${compare.summoner}</h3>
            </div>
            <div>
                <div class="col-lg-2 col-md-2 col-sm-2">Kills: ${main.averageKills}</div>
                <div class="col-lg-2 col-sm-2  col-md-offset-8 col-sm-offset-8 col-lg-offset-8 col-md-2">Kills: ${compare.averageKills}</div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" 
                             role="progressbar" 
                             style="width:<c:out value="${(main.averageKills / (main.averageKills + compare.averageKills)) * 100}"/>%">
                          ${main.averageKills}
                        </div>                        
                        <div class="progress-bar progress-bar-danger" 
                             role="progressbar" 
                             style="width:<c:out value="${(compare.averageKills / (main.averageKills + compare.averageKills)) * 100}"/>%">
                          ${compare.averageKills}
                        </div>
                    </div>
                </div>
                
            </div>
           <div>
                <div class="col-lg-2 col-md-2 col-sm-2">Deaths: ${main.averageDeaths}</div>
                <div class="col-lg-2 col-sm-2  col-md-offset-8 col-sm-offset-8 col-lg-offset-8 col-md-2">Deaths: ${compare.averageDeaths}</div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" 
                             role="progressbar" 
                             style="width:<c:out value="${(main.averageDeaths / (main.averageDeaths + compare.averageDeaths)) * 100}"/>%">
                          ${main.averageDeaths}
                        </div>                        
                        <div class="progress-bar progress-bar-danger" 
                             role="progressbar" 
                             style="width:<c:out value="${(compare.averageDeaths / (main.averageDeaths + compare.averageDeaths)) * 100}"/>%">
                          ${compare.averageDeaths}
                        </div>
                    </div>
                </div>
                
            </div>
            <div>
                <div class="col-lg-2 col-md-2 col-sm-2">Assists: ${main.averageAssists}</div>
                <div class="col-lg-2 col-sm-2  col-md-offset-8 col-sm-offset-8 col-lg-offset-8 col-md-2">Assists: ${compare.averageAssists}</div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" 
                             role="progressbar" 
                             style="width:<c:out value="${(main.averageAssists / (main.averageAssists + compare.averageAssists)) * 100}"/>%">
                          ${main.averageAssists}
                        </div>                        
                        <div class="progress-bar progress-bar-danger" 
                             role="progressbar" 
                             style="width:<c:out value="${(compare.averageAssists / (main.averageAssists + compare.averageAssists)) * 100}"/>%">
                          ${compare.averageAssists}
                        </div>
                    </div>
                </div>
                
            </div>
            <div>
                <div class="col-lg-2 col-md-2 col-sm-2">Creep Score: ${main.averageCreepScore}</div>
                <div class="col-lg-2 col-sm-2  col-md-offset-8 col-sm-offset-8 col-lg-offset-8 col-md-2">Creep Score: ${compare.averageCreepScore}</div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" 
                             role="progressbar" 
                             style="width:<c:out value="${(main.averageCreepScore / (main.averageCreepScore + compare.averageCreepScore)) * 100}"/>%">
                          ${main.averageCreepScore}
                        </div>                        
                        <div class="progress-bar progress-bar-danger" 
                             role="progressbar" 
                             style="width:<c:out value="${(compare.averageCreepScore / (main.averageCreepScore + compare.averageCreepScore)) * 100}"/>%">
                          ${compare.averageCreepScore}
                        </div>
                    </div>
                </div>
                
            </div>
            <div>
                <div class="col-lg-2 col-md-2 col-sm-2">Total Gold: ${main.averageTotalGold}</div>
                <div class="col-lg-2 col-sm-2  col-md-offset-8 col-sm-offset-8 col-lg-offset-8 col-md-2">Total Gold: ${compare.averageTotalGold}</div>
                <div class="col-lg-12 col-md-12 col-sm-12">
                    <div class="progress">
                        <div class="progress-bar progress-bar-success" 
                             role="progressbar" 
                             style="width:<c:out value="${(main.averageTotalGold / (main.averageTotalGold + compare.averageTotalGold)) * 100}"/>%">
                          ${main.averageTotalGold}
                        </div>                        
                        <div class="progress-bar progress-bar-danger" 
                             role="progressbar" 
                             style="width:<c:out value="${(compare.averageTotalGold / (main.averageTotalGold + compare.averageTotalGold)) * 100}"/>%">
                          ${compare.averageTotalGold}
                        </div>
                    </div>
                </div>
                
            </div>
            <div>
                <a href="MainPage">Back to Main</a>
            </div>
        </row>
            
    <script type="text/javascript" src="webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="webjars/jquery/2.1.1/jquery.min.js"></script>        
    </body>
</html>
