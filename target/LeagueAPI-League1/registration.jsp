<%-- 
    Document   : registration
    Created on : Mar 29, 2016, 2:33:10 PM
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Register a new account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <h1>Create an account</h1>
        
        <form action="Register" method="POST">
            <p class="centerMe">In order to protect your League of Legends account,
            DO NOT use either your Riot Games username OR password 
            to register with our system.</p>
            <table class="registrationTable">
                <tr>
                    <td>
                        <table>
                            <tr>
                                <td>
                                    Username: 
                                </td>
                                <td>
                                    <input type="text" name="username">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Password: 
                                </td>
                                <td>
                                    <input type="password" name="password">
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Summoner Name:
                                </td>
                                <td>
                                    <input type="text" name="sumName">
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="Register" class="centerMe">
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>

