<%-- 
    Document   : profilo
    Created on : 27-apr-2017, 11.21.12
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Profilo:</title>
        <meta charset="UTF-8">
        <!-- Specifico il charset esplicitamente con un tag meta, cosi da poter usare i caratteri accentati -->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Roberta Galici">
        <meta name="keywords" content="nerdbook nerd social network amici amicizie nuovi">

        <link rel="stylesheet" type="text/css" href="style.css" media="screen">
    </head>

    <body>
        <div id="title">
            <h1>NerdBook</h1>
            <!-- Titolo -->
        </div>
        <!--Chiedo all'utente di inserire i seguenti campi:
            Nome dell’utente
            Cognome dell’utente
            URL di una immagine per il profilo
            Frase di presentazione
            Data di nascita
            Password
            Conferma password-->

        <div id="divBody">

            <img title="fotoProfiloMario" alt="Foto di Mario" src="immagini/SuperMario.jpg">
            <form action="#" method="post">     
                <label for="nome">Nome:</label>
                <input type="text" name="nome" id="nome">
                <br>
                <label for="cognome">Cognome:</label>
                <input type="text" name="cognome" id="cognome">
                <br>
                <label for="urlImg">URL dell'immagine del profilo:</label>
                <input type="url" name="URL" id="urlImg">
                <br>
                <label for="presentazione">Presentati:</label>
                <textarea rows="4" cols="20"
                          name="lungo" id="presentazione" >Scrivi qua...
                </textarea>
                <br>
                <label for="data">Data di nascita:</label>
                <input type="date" name="data" id="data">
                <br> 
                <label for="passw">Password:</label>
                <input type="password" name="pass" id="passw">
                <br>
                <label for="confermaPswd">Conferma password:</label>           
                <input type="password" name="confermaPswd" id="confermaPswd">
                <button type="submit"> Registrati
                </button>
            </form>
        </div>

        <div class="goTo">
            <c:if test="${page!='login'}">
                <jsp:include page="nav.jsp"/>
            </c:if>
        </div>
        
        <c:set var="pag" value="profilo" scope="request"/>
        <jsp:include page="sidebar.jsp"/>

    </body>
</html>