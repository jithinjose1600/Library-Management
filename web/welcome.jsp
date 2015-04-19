<%-- 
    Document   : welcome
    Created on : Apr 18, 2015, 9:05:04 PM
    Author     : JITHZZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%String name=(String)session.getAttribute("name");%>
        <h1>Welcome, <%=name%></h1>
        <a href="./books" class="btn btn-large btn-block btn-primary">View Books</a>
       <a href="updateMember.jsp" class="btn btn-large btn-block btn-primary">Edit Profile</a><br>
        <a href="./records" class="btn btn-large btn-block btn-primary">View records</a><br>
        <a href="logout.jsp" class="btn btn-large btn-block btn-primary">Logout</a>
    </body>
</html>
