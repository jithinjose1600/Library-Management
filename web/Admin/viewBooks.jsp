<%-- 
    Document   : viewBooks
    Created on : 17-Apr-2015, 11:42:54 AM
    Author     : c0648991
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
           <table border="10" bordercolor=#0000ff>
                <tr>
                    <th><h3>Book ID</h3></th>
                    <th><h3>Book Name</h3></th>
                    <th><h3>Author Name</h3></th>
                    <th><h3>Category</h3></th>
                    <th><h3>Description</h3></th>
                    <th><h3>Quantity</h3></th>
                    <th><h3>Available</h3></th>
                    <th><h3>Edit/Delete</h3></th>
                </tr>
        	
                 <%
                 if (request.getAttribute("book")!= null)
                     {
                  List lst=(List)request.getAttribute("book");
                   Iterator itr;
                     for(itr=lst.iterator();itr.hasNext();)
                         { 
                           String bid=(String)itr.next();
                           String bname=(String)itr.next();
                           String author=(String)itr.next();
                           String category=(String)itr.next();
                           String description=(String)itr.next();
                           String quantity=(String)itr.next();
                           String available=(String)itr.next();
                         %>
                         <tr> <td><h4><%=bid%></h4></td>
                         <td><h4><%=bname%></h4></td>
                         <td><h4><%=author%></h4></td>
                         <td><h4><%=category%></h4></td>
                        <td><h4><%=description%></h4></td>
                        <td><h4><%=quantity%></h4></td>
                    <td><h4><%=available%></h4></td>
                    <td>
                        <form action="Admin/updateBooks.jsp">
                            <input type="hidden" value="<%=bid%>" name="id"/>
                            <input type="hidden" value="<%=bname%>" name="title"/>
                            <input type="hidden" value="<%=author%>" name="author"/>
                            <input type="hidden" value="<%=category%>" name="category"/>
                            <input type="hidden" value="<%=description%>" name="description"/>
                            <input type="hidden" value="<%=quantity%>" name="quantity"/>
                            <input type="Submit" name="Edit"/>
                        </form>
                            <a href='deletebooks.do?id=<%=bid%>'>Delete</a></h4></td>
                 </tr>
                 
                         <%
                         
                     }
                   }
                 
                 %>
         
         </table>
    </body>
</html>
