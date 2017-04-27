<%-- 
    Document   : header
    Created on : 26-apr-2017, 18.26.37
    Author     : Robi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<div id="header">
    <div id="title">
        <h1>NerdBook</h1>
        <!-- Titolo -->
    </div>

    <c:if test="${page!='login'}">
        <jsp:include page="nav.jsp"/>
    </c:if>
</div>
