<%-- 
    Document   : login
    Created on : 15-Apr-2015, 3:48:18 PM
    Author     : c0648991
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css" rel="stylesheet"/>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Login Here</h1>
        <section class="container">
            <div class="col-md-8">
                <form action="login">
                <div class="form-group">
                    <label for="fname">Email:</label>
                    <input id="fname" name="email" class="form-control"/>
                    <label for="lname">Password:</label>
                    <input id="lname" name="password" class="form-control"/>
                </div>
                <button id="Login" class="btn btn-default">Register</button>
                <a href="memberRegister.html">New User, Register</a>
                </form>
            </div>
        </section>
    </body>
</html>
