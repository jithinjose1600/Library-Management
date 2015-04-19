<%-- 
    Document   : viewRecords
    Created on : Apr 18, 2015, 6:01:07 PM
    Author     : JITHZZ
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
    </head>
    <body>
           <table border="10" bordercolor=#0000ff>
                <tr>
                    <th><h3>Book ID</h3></th>
                    <th><h3>Book Name</h3></th>
                    <th><h3>Issue Date</h3></th>
                    <th><h3>Return Date</h3></th>
                </tr>
        	
                 <%
                 if (request.getAttribute("record")!= null)
                     {
                  List lst=(List)request.getAttribute("record");
                   Iterator itr;
                     for(itr=lst.iterator();itr.hasNext();)
                         { 
                           String bid=(String)itr.next();
                           String bname=(String)itr.next();
                           String isdate=(String)itr.next();
                           String redate=(String)itr.next();
                         %>
                         <tr> <td><h4><%=bid%></h4></td>
                         <td><h4><%=bname%></h4></td>
                         <td><h4><%=isdate%></h4></td>
                         <td><h4><%=redate%></h4></td>
                 </tr>
                 
                         <%
                         
                     }
                   }
                 
                 %>
    </body>
</html>
