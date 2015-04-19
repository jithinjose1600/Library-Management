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
        <title>Books</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <section class="container">
            <div class="col-md-8">
        <h1>List of Books</h1>
           <table border="10" bordercolor=#0000ff>
                <tr>
                    <th><h3>Book ID</h3></th>
                    <th><h3>Book Name</h3></th>
                    <th><h3>Author Name</h3></th>
                    <th><h3>Category</h3></th>
                    <th><h3>Description</h3></th>
                    <th><h3>Available</h3></th>
                    <th><h3>Booking</h3></th>
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
                    <td><h4><%=available%></h4></td>
                   <% 
                   if(Integer.parseInt(available)>0) {
                   %>
                   <td></h4><a href='./booking?id=<%=bid%>&name=<%=bname%>'>Book Now</a></h4></td>
                    <%
                   }
                   else {
                       
%>
                    <td><h4>unavailable</h4></td>
                 </tr>
                 
                         <%
                         } 
                     }
                   }
                 
                 %>
         
         </table>
            </div>
        </section>
    </body>
</html>
