<%-- 
    Document   : bacheca
    Created on : 26-apr-2017, 18.27.07
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>

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
        
        <c:set var="page" value="newPost" scope="request"/>
        <jsp:include page="newPost.jsp"/>
                
        
            <div id="divBody">
                <c:forEach var="post" items="${listaPost}">
                    
                        <c:if test="${post.postType == 'NULL'}">
                         <div id="mario" class="post">
                            <h3>${utente1.nome} ${utente1.cognome}</h3>
                            <div class="fotoProfilo">
                               <img title="fotoProfiloMario" alt="Foto di Mario" src="${utente1.urlProfilo}">
                            </div>
                            <p>${post1.contentText}</p>
                        </div>
                        
                        
                        </c:if>
                        <c:if test="${post.postType == 'IMAGE'}">
                           
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
                            
                            <div id="luigi" class="post">
                                <h3>${utente3.nome} ${utente3.cognome}</h3>
                                <div id="fotoLmini">
                                <img title="fotoProfiloLuigi" alt="Foto di Luigi" src="immagini/luigi.png">
                                </div>
                                <p>${post3.contentText}</p>
                                <div id="fotoL">
                                <img alt="Foto di Mario e Luigi" src="immagini/MeL.jpg">
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${post.postType == 'LINK'}">
                            <div id="crash" class="post">
                                <h3>${utente3.nome} ${utente3.cognome}</h3>
                                <img title="fotoProfiloCrash" alt="Foto di Crash" src="immagini/crash.jpg">                    
                                <p>Ehi Cortex, dai un'occhiata qua: <a href="https://www.youtube.com/watch?v=DYjcZ5e5-iM" target="_blank"> https://www.youtube.com/watch?v=DYjcZ5e5-iM </a></p>
                            </div>
                        </c:if>
                    
                </c:forEach>
                
                 <div id="newPost">
                    <form action="confermaPost.jsp" method="POST">
                        <input type="hidden" name="bachecaTarget" value="${user.id}"/>
                        <textarea name="textPost" id="textPost">Testo post</textarea>
                        <input type="url" name="urlPost" id="urlPost" value="http://google.com"/>
                        <label for="textType">Immagine</label>
                        <input type="radio" name="postType" value="imgType" id="textType">
                        <label for="textType">Link</label>
                        <input type="radio" name="postType" value="linktType" id="textType">
                        <button type="submit">Pubblica</button> 
                    </form>
                </div>
   
            </div>
            
    </body>
</html>

