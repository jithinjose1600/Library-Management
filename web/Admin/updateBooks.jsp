<%-- 
    Document   : updateBooks
    Created on : 16-Apr-2015, 8:49:27 PM
    Author     : c0648991
--%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Books</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Update Books</h1>
        <section class="container">
            <div class="col-md-8">
                <form action="updatebooks" method="POST">
                     <%
                         String bid=request.getParameter("id");
                         String bname=request.getParameter("title");
                         String bauthor=request.getParameter("author");
                         String bcategory=request.getParameter("category");
                         String bdescription=request.getParameter("description");
                         String bquantity=request.getParameter("quantity");
                                              
                                              %>
                                              
                <div class="form-group">
                    <label for="b_id">Book ID:</label>
                    <input id="b_id" name="b_id" class="form-control"/> <!--readonly="readonly"-->
                    <label for="b_name">Book Name:</label>
                    <input id="b_name" name="b_name" class="form-control"/>
                    <label for="b_author">Author:</label>
                    <input id="b_author" name="b_author" class="form-control"/>
                    <label for="b_category">Category:</label>
                    <input id="b_category" name="b_category" class="form-control"/>
                    <label for="b_description">Description:</label>
                    <input id="b_description" name="b_description" class="form-control"/>
                    <label for="b_quantity">Quantity:</label>
                    <input id="b_quantity" name="b_quantity" class="form-control"/>
                </div>
                <button id="update" class="btn btn-default">UPDATE</button>
                </form>
            </div>
        </section>
    </body>
</html>
