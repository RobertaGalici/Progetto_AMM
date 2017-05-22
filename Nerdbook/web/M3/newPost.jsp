<%-- 
    Document   : newPost
    Created on : 17-mag-2017, 17.07.01
    Author     : Robi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <title>NerdBook</title>
        
        <meta charset="UTF-8">
        <!-- Specifico il charset esplicitamente con un tag meta, cosi da poter usare i caratteri accentati -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Roberta Galici">
        <meta name="keywords" content="nerdbook nerd social network amici amicizie nuovi">
        
        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
        
    </head>

    <body>
         <c:set var="pag" value="newPost" scope="request"/>
        <jsp:include page="header.jsp"/>
        
         <c:set var="page" value="newPost" scope="request"/>
        <jsp:include page="sidebar.jsp"/>

        <!--Contenuti della pagina-->
        <div id="divBody">
            <c:choose>
                <c:when test="${empty newPost}">
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <div id="postType">
                                <div>
                                    <label for="textType">Post con Link</label>
                                    <input type="radio" name="postType" value="linkType" id="linkType" checked="checked">
                                </div>
                                <div>
                                    <label for="imgType">Post con Foto</label>
                                    <input type="radio" name="postType" value="imgType" id="imgType">
                                </div>
                            </div>
                            <div id="postContent">
                                <div>
                                    <label for="textPost">Contenuto</label>
                                    <textarea name="textPost" id="textPost"></textarea>
                                </div>
                            </div>
                            <button type="submit" name="thereIsPost" value="needConfirm">Invia</button>
                        </form>     
                    </div>
                </c:when>
                <c:otherwise>
                    <div id="formNewPost">
                        <form action="NuovoPost" method="post">
                            <c:if test="${typePost == 'textType'}">
                                <p>${content}</p>
                            </c:if>
                            <c:if test="${typePost == 'imgType'}">
                                <img src="${content}" alt="downloadedImage">
                            </c:if>
                            <input type="text" hidden name="textPost" value="${content}">
                            <input type="text" hidden name="postType" value="${typePost}">
                            <button type="submit" name="thereIsPost" value="Confirmed">Conferma</button>
                        </form>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
              
    </body>
</html>
