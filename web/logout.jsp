<%-- 
    Document   : logout
    Created on : Apr 18, 2015, 6:49:55 PM
    Author     : JITHZZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession ses=request.getSession(false);
            if(ses!=null)
                ses.invalidate();
            response.sendRedirect("login.jsp");
        %>
    </body>
</html>
