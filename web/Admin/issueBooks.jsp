<%-- 
    Document   : issueBooks
    Created on : Apr 18, 2015, 12:15:46 PM
    Author     : JITHZZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issue Books</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script type="text/javascript"> 
            DisablePast=false;
            range_start=new Date(2006,11-1,8);
            range_end=new Date(2006,11-1,5);
         </script>   
        
    </head>
    <body>
        
        <section class="container">
            <div class="col-md-8">
                <h1>Issue Books</h1>
                <form action="../issue" method="POST">
                <div class="form-group">
                    <label for="u_id">User Id:</label>
                    <input id="u_id" name="u_id" class="form-control"/>
                    <label for="f_name">First Name:</label>
                    <input id="f_name" name="f_name" class="form-control"/>
                    <label for="l_name">Last Name:</label>
                    <input id="l_name" name="l_name" class="form-control"/>
                    <label for="b_id">Book Id:</label>
                    <input id="b_id" name="b_id" class="form-control"/>
                    <label for="b_name">Book Name:</label>
                    <input id="b_name" name="b_name" class="form-control"/>
                    <label for="is_date">Date of Issue:</label>
                    <input id="is_date" name="is_date" onclick="GetDate(this)" class="form-control"/>
                </div>
                <button id="issue" class="btn btn-default">ISSUE BOOK</button>
                </form>
            </div>
        </section>
    </body>

