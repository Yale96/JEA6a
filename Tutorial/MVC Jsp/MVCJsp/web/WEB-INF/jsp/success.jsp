<%-- 
    Document   : success
    Created on : 12-feb-2018, 16:36:33
    Author     : Yannick van Leeuwen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
        <title>Insert title here</title>
    </head>
    <body>

        Welcome ${requestScope['user'].username}. 

    </body>
</html>
