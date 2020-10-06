<%-- 
    Document   : updateInfo
    Created on : 3/10/2020, 01:05:02 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h1 align="center">Informacion</h1><br><br>
        <table>
            <tr>
            <td width="20%">${a.id}</td>
            <td width="20%">${a.nameStudent}</td>
            <td width="20%">${a.email}</td>            
            </tr>
        </table>
       
    <a onclick="return confirm('Esta seguro?')" href="AccountServlet?action=delete&id=${a.id}">Delete</a>
    <a href="edit.jsp">Edit</a>
    </body>
</html>
