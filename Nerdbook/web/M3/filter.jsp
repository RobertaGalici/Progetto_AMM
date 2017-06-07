<%-- 
    Document   : listaUtentiJson
    Created on : 4-giu-2017, 15.10.48
    Author     : Roby
--%>

<%@page contentType="application/json" pageEncoding="UTF-8"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<json:array>
    <c:forEach var="post" items="${listaUtenti}">
        <json:object>
            <json:property name="id" value="${post.id}"/>
            <json:property name="nome" value="${post.nome}"/>
            <json:property name="cognome" value="${post.cognome}"/>
            <json:property name="email" value="${post.email}"/>
            <json:property name="password" value="${post.password}"/>
            <json:property name="urlProfilo" value="${post.urlProfilo}"/>
            <json:property name="dataNascita" value="${post.dataNascita}"/>
            <json:property name="presentazione" value="${post.presentazione}"/>
        </json:object>
    </c:forEach>
</json:array>

