<%-- 
    Document   : login
    Created on : 27-apr-2017, 11.31.00
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <title>Login Nerdbook</title>
    <meta charset="UTF-8">
    <!-- Specifico il charset esplicitamente con un tag meta, cosi da poter usare i caratteri accentati -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="Roberta Galici">
    <meta name="keywords" content="nerdbook nerd social network amici amicizie nuovi">
    
    <link rel="stylesheet" type="text/css" href="M3/style.css" media="screen">
</head>

<body>
    
    <div id="header">
    <div id="loginHeader">
        <img title="fotoSito" src="M3/immagini/logo.png" alt="LogoSito">
        <h1>NerdBook</h1>
        <!-- Titolo -->
    </div>
    
    <div id="riquadroLogin">
        <div id="login">
        <h3>Login:</h3>
        </div>

        <form action="#" method="post">
            
            <c:if test="${invalidData == true}">
               <div id="invalidDataWarning">I dati inseriti non sono corretti</div>
            </c:if>
               
                <div>
                    <label for="userName">Username:</label>
                    <input type="text" name="username" id="userName">
                </div>
                <div>
                    <label for="userpsw">Password:</label>
                    <input type="password" name="password" id="userpsw">
                </div>
                <button id="button" type="submit"> Accedi</button>
        </form>
    </div>
  </div>

</body>

</html>
