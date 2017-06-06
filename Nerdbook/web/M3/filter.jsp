<%-- 
    Document   : listaUtentiJson
    Created on : 4-giu-2017, 15.10.48
    Author     : Roby
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="gatto" items="${listaUtenti}">
        <json:object>
            <json:property name="id" value="${utente.id}"/>
            <json:property name="nome" value="${utente.nome}"/>
            <json:property name="cognome" value="${utente.cognome}"/>
            <json:property name="email" value="${utente.email}"/>
            <json:property name="password" value="${utente.password}"/>
            <json:property name="urlProfilo" value="${utente.urlProfilo}"/>
            <json:property name="dataNascita" value="${utente.dataNascita}"/>
            <json:property name="presentazione" value="${utente.presentazione}"/>
        </json:object>
    </c:forEach>
</json:array>

