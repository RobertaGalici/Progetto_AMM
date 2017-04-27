<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 18.27.07
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
                
        
            <div id="divBody">
                <c:forEach var="post" items="${listaPost}">
                    
                        <c:if test="${post.postType == 'TEXT'}">
                           
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                           
                        </c:if>
                    
                </c:forEach>
                
                 <!--Singolo post di testo-->
                 <div id="mario" class="post">
                    <h3>${utente1.nome} ${utente1.cognome}</h3>
                    <div class="fotoProfilo">
                        <img title="fotoProfiloMario" alt="Foto di Mario" src="${utente1.urlProfilo}">
                    </div>
                     <p>${post1.contentText}</p>
                </div>
                <!--Singolo post con una foto-->
                <div id="cortex" class="post">
                    <h3>${utente2.nome} ${utente2.cognome}</h3>
                    <div id="fotoC">
                    <img title="fotoProfiloCortex" alt="Foto di Dott. Neo Cortex" src="${utente2.urlProfilo}">
                    </div>
                    <p>${post2.contentText}</p>
                    <div id="foto">
                        <img alt="Foto di Crash e Dott. Cortex" src="immagini/CrasheNeo.jpg">
                    </div>
                    
                </div>
                
                <!--Singolo post con un link-->
                 <div id="crash" class="post">
                    <h3>${utente3.nome} ${utente3.cognome}</h3>
                    <img title="fotoProfiloCrash" alt="Foto di Crash" src="immagini/crash.jpg">                    
                    <p>Ehi Cortex, dai un'occhiata qua: <a href="https://www.youtube.com/watch?v=DYjcZ5e5-iM" target="_blank"> https://www.youtube.com/watch?v=DYjcZ5e5-iM </a></p>
                </div>
                
                <!--Singolo post con una foto-->
                <div id="luigi" class="post">
                    <h3>Luigi</h3>
                    <div id="fotoLmini">
                    <img title="fotoProfiloLuigi" alt="Foto di Luigi" src="immagini/luigi.png">
                    </div>
                    <p>Mario, guarda come eravamo giovani!</p>
                    <div id="fotoL">
                    <img alt="Foto di Mario e Luigi" src="immagini/MeL.jpg">
                    </div>
                </div>
                
            </div>
            
    </body>
</html>

