<%--
    Document   : nav
    Created on : 26-apr-2017, 18.30.23
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav>    
    <ol>
        <c:choose>
                <c:when test = "${page==bacheca}">
                    <li><a href="profilo.html">Profilo</a></li>
                    <li class="activ"><a href="bacheca.html">Bacheca</a></li>
                    <li><a href="descrizione.html">Descrizione</a></li>
                    <li><a href="login.html">Login</a></li>
                    <li><p>Mario Bros</p><a href="login.html">Logout</a></li>
                </c:when>
                <c:when test="${page==descrizione}">
                    
                    <li><a href="login.html">Login</a></li>
                    <li><a href="profilo.html">Registrati</a></li>   
                    <li> <a href="bacheca.html">Bacheca</a></li>
                    <li id="active"><a href="descrizione.html">Descrizione</a></li>
                    
                </c:when>   
                <c:when test="${page==profilo}">
                
                    <li id="active"><a href="profilo.html">Profilo</a></li>
                    <li><a href="bacheca.html">Bacheca</a></li>
                    <li><p>Mario Bros</p><a href="login.html">Logout</a></li>

                </c:when>    
                <c:when test="${page==newPost}">
                
                    <li><a href="profilo.html">Profilo</a></li>
                    <li><a href="bacheca.html">Bacheca</a></li>
                    <li><a href="descrizione.html">Descrizione</a></li>
                    <li><a href="login.html">Login</a></li>

                </c:when>    
                
        </c:choose>
        

    </ol>
</nav>  