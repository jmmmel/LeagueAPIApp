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
    </head>
    <body>
        <table>
            <tr>
                <td><h3>${main.summoner}</h3></td>
                <td><h4>Vs.</h4></td>
                <td><h3>${compare.summoner}</h3></td>
            </tr>
        </table>
            <a href="MainPage">Back to Main</a>
    </body>
</html>
