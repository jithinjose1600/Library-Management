<%-- 
    Document   : returnBooks
    Created on : Apr 18, 2015, 5:16:32 PM
    Author     : JITHZZ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Return Books</title>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
        <script type="text/javascript"> 
            DisablePast=false;
            range_start=new Date(2006,11-1,8);
            range_end=new Date(2006,11-1,5);
         </script>   
        
    </head>
    <body>
        <h1>Return Books</h1>
        <section class="container">
            <div class="col-md-8">
                <form action="../return" method="POST">
                <div class="form-group">
                    <label for="u_id">User Id:</label>
                    <input id="u_id" name="u_id" class="form-control"/>
                    <label for="b_id">Book Id:</label>
                    <input id="b_id" name="b_id" class="form-control"/>
                    <label for="re_date">Date of Return:</label>
                    <input id="re_date" name="re_date" onclick="GetDate(this)" class="form-control"/>
                </div>
                <button id="return" class="btn btn-default">RETURN BOOK</button>
                </form>
            </div>
        </section>
    </body>
</html>
