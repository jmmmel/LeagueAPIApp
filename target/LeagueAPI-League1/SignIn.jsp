<%-- 
    Document   : SignIn
    Created on : Mar 1, 2016, 10:29:29 AM
    Author     : James
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>League Compare</title>
    <script src="jquery/jquery-2.2.0.min.js"></script>
    <link href="./css/main.css" rel="stylesheet" />
    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font awesome -->
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        
    </style>
</head>

<body>
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row">
                <div class=""><h2>League Compare</h2></div>
                <c:if test="${errorSignIn}">
                    <div class="centered">
                        <div class="error">Incorrect Username or Password</div>
                    </div>
                </c:if>
                <form action="Authenticate" method="POST">
                    <fieldset class="sign-in-field col-lg-5">                        
                        <div class="control-group">
                            <label class="field-left" for="username">Username:&nbsp;</label>
                            <input class="field-right" id="username" type="text" name="username">
                        </div>
                        <div class="control-group">
                            <label class="field-left" for="password">Password: </label>                            
                            <input class="field-right" id="password" type="password" name="password">                            
                        </div>
                        <div class="clear"></div>
                        <input type="submit" value="Login"><br>
                        All information is public and obtained from the Riot 
                        Games API. Visit https://developer.riotgames.com/terms 
                        for more details.
                    </fieldset>
                </form>
            </div>
        </div>
    </div>


    <!-- Menu Toggle Script -->
</body>

</html>


