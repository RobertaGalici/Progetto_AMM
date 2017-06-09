<%-- 
    Document   : cercaAmici
    Created on : 5-giu-2017, 10.01.06
    Author     : Roby
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Bacheca:</title>
        <meta charset="UTF-8">
        <!-- Specifico il charset esplicitamente con un tag meta, cosi da poter usare i caratteri accentati -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Roberta Galici">
        <meta name="keywords" content="nerdbook nerd social network amici amicizie nuovi">
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        
    </head>
    <body>
        <c:set var="page" value="bacheca" scope="request"/>
        <jsp:include page="header.jsp"/>
            
        <c:set var="page" value="sidebar" scope="request"/>
        <jsp:include page="sidebar.jsp"/>
        
        
        <!--Contenuti della pagina-->
        <div id="divBody">
            <div id="searchFriend">
                <input id="searchField" type="text" placeholder="Cerca qua il tuo Nerd!" value="">
                <button id="search">Cerca Nerd</button>
            </div>
            <div id="usersList">
                <c:forEach var="utente" items="${utenti}">
                    <div class="user">
                        <div class="profilePic">
                            <img alt="Foto Profilo" src="${user.urlProfilo}">
                        </div>
                        <div class="userData">
                            <h2>${user.nome} ${user.cognome}</h2>
                            <a href="Bacheca?user=${user.id}">Link al profilo</a>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </body>
</html>
