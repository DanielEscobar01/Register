<%-- 
    Document   : listAccounts
    Created on : 24/09/2020, 06:54:26 PM
    Author     : Juan
<a onclick="return confirm('Esta seguro?')" href="AccountServlet?action=delete&id=${a.id}">Delete</a>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>lista de materias</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1 align="center">Lista de Materias</h1>
            <table width="50%" align="center">
            <c:forEach var="a" items="${subjects}">
                <tr>
                <td width="20%">${a.idSubject}</td>
                <td width="20%">${a.nameSubject}</td>
                </tr>
        </c:forEach>
        </table>
    </body>
</html>
