<%-- 
    Document   : confermaPost
    Created on : 19-mag-2017, 16.49.45
    Author     : Robi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Riepilogo dei dati inseriti:</h1>
        <h3>Autore del post:</h3>
        <p>${loggedUser.nome}</p>
        <h2>Proprietario della Bacheca:</h2>
        <p>${param.bachecaTarget}</p>
        <h2>Testo Post</h2>
        <p>${param.textPost}</p>
        <h2>Link Post</h2>
        <p>${param.urlPost}</p>
        <h2>Tipo Post</h2>
        <c:choose>
            <c:when test="${param.postType == 'linktType' }" >
                <p>Link</p>
            </c:when>
            <c:when test="${param.postType == 'imgType' }" >
                <p>Immagine</p>
            </c:when>
            <c:otherwise>
                <p>Testo</p>
            </c:otherwise>        
        </c:choose>
        <div id="newPost">
                <form action="newPost.jsp" method="POST">
                    <input type="hidden" name="bachecaTarget" value="${param.bachecaTarget}"/>
                    <label>Vuoi confermare il post?</label>
                    <button type="submit">Conferma</button> 
                </form>
        </div>
        
    </body>
</html>