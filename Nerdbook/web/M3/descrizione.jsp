<%-- 
    Document   : descrizione
    Created on : 27-apr-2017, 11.06.39
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

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
        <c:set var="pag" value="descrizione" scope="request"/>
        <jsp:include page="header.jsp"/>
        
        <div id ="new">
            <div id = "new1"><a href="#descr">Descrizione</a></div>
            <div id = "new2"><a href="#2p">Adatto a</a></div>
            <div id = "new3"><a href="#costo">Costo</a></div>
            <div id = "new4"><a href="#log">Come accedere</a></div>
            <div id = "new5"><a href="#curiosita">Curiosità</a></div>
        </div>
        
        <div id="divBody">
            
            
            <a id="descr"><h2>Descrizione:</h2></a>
            <p>Questo social network è rivolto a coloro che vogliono conoscere nuove persone in maniera virtuale, per tenersi in contatto con gli amici o per divertimento.</p>
            <div id='Section'>
                <a id="2p"><h3>Adatto a:</h3></a>
                <p>E' adatto a tutti, dai più piccoli ai più anziani, quindi, anche se hai 100 anni e hai voglia di fare nuove amicizie, sei nel posto che fa per te!</p>
                <a id="costo"><h3>Si paga?</h3></a>
                <p>No! Questo social è totalmente gratuito</p>
                <a id="log"><h3>Come accedere:</h3></a>
                <p>Per accedere a NerdBook, è necessario creare un account gratuito
                    sul sito. Su NerdBook è necessario un indirizzo di posta elettronica valido.
                    Usando NerdBook è possibile: stringere amicizie e creare e gestire dei gruppi
                    Si possono ricercare amici in diversi modi, esiste anche un motore
                    di ricerca per rintracciare una persona specifica e molto altro ancora.</p>
                <!-- link esterno in una nuova pagina -->
                <a id="curiosita"><h3>Curiosità:</h3></a>
                <a href="http://www.fotoscrittura.it/a-cosa-servono-i-social-network/" target="_blank">
                    Informazioni generali sui social network</a>
                            
            </div>
                
        </div>
          
    </body>
</html>
