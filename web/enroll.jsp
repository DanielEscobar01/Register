<%-- 
    Document   : enroll
    Created on : 4/10/2020, 01:50:59 PM
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="style.css">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">    
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
        <title>JSP Page</title>
    </head>
<body>
        <jsp:include page="menu.jsp"></jsp:include>
             
        <div class="container well">
            
            <div align="center">
                <h1> ENROLL </h1>
                
                <form action="AccountServlet?action=enroll" method="post">
                <table>
                    <tr>
                        <th width="100px"><label><b>Id:</b></label></th>
                        <th>
                        <input type="text" placeholder="Enter Id" class="form-control" name="id_subject" required=""/> 
                        </th>
                    </tr>
                    <tr>
                    <div class="break"></div>
<tr>
                        <td colspan="2">
                            <input class="btn btn-info btn-lg" type="submit" name="action" value="Enroll" style="margin-right: 20px;">
                        </td>
                    </tr>
                </table>     
        </form>
                </div>
        </div>
    </body>
</html>

