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
    <script src="http://code.jquery.com/jquery.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script>

            $(document).ready(function() {
                $('#update').click(function() {
                    $.ajax({
                        url: "../u/updatebooks",
                        dataType: "json",
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify({"bookid": $("#b_id").val(),
                            "booktitle": $("#b_name").val(),
                            "author": $("#b_author").val(),
                            "category": $("#b_category").val(),
                            "description": $("#b_description").val(),
                            "quantity": $("#b_quantity").val()}),
                        method: "put",                       
                        success: window.location.href = "viewBooks.jsp";
                                //function(result) {
                        //if(result==1) 
                            
                    //}
                    });
                });
            });
        </script>
    </head>
    <body>
        
        <section class="container">
            <div class="col-md-8">
                <h1>Update Books</h1>
                <form id="updateform">
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
                    <input id="b_id" value="<%=bid%>" name="b_id" readonly="readonly" class="form-control"/> 
                    <label for="b_name">Book Name:</label>
                    <input id="b_name" value="<%=bname%>" name="b_name" class="form-control"/>
                    <label for="b_author">Author:</label>
                    <input id="b_author" value="<%=bauthor%>" name="b_author" class="form-control"/>
                    <label for="b_category">Category:</label>
                    <input id="b_category" value="<%=bcategory%>" name="b_category" class="form-control"/>
                    <label for="b_description">Description:</label>
                    <input id="b_description" value="<%=bdescription%>" name="b_description" class="form-control"/>
                    <label for="b_quantity">Quantity:</label>
                    <input id="b_quantity" value="<%=bquantity%>" name="b_quantity" class="form-control"/>
                </div>
                <button id="update" class="btn btn-default">UPDATE</button>
                </form>
            </div>
        </section>
    </body>
</html>
