<%-- 
    Document   : login
    Created on : 12-feb-2018, 16:36:21
    Author     : Yannick van Leeuwen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Insert title here</title>
    </head>
    <body>
        <form action="LoginController" method="post">
            Enter username : <input type="text" name="username"> <BR>
            Enter password : <input type="password" name="password"> <BR>
            <input type="submit" />
        </form>
    </body>
</html>
