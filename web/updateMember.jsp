<%-- 
    Document   : updateMember
    Created on : 17-Apr-2015, 2:59:46 PM
    Author     : c0648991
--%>

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
     
  var uid= '<%=session.getAttribute("id")%>';
  alert(uid);
  $(document).ready(function() {
               //var uid = sessionStorage.getItem("id");
               
                $.ajax({url: "./u/users/"+uid,
                    dataType: "json",
                    method:"get",
                    success: function(data) {
                     for (var i = 0; i < data.length; i++) 
                     {
                         $('#uid').val(uid);
                         $('#fname').val(data[i].firstName);
                     $('#lname').val(data[i].lastName);
                     $('#address').val(data[i].address);
                     $('#phone').val(data[i].phone);
                     $('#email').val(data[i].email);
                     $('#password').val(data[i].password);
                 }
                    }
                });
           
                $('#update').click(function() {
                    $.ajax({
                        url: "./u/users"+uid,
                        dataType: "json",
                        contentType: 'application/json; charset=UTF-8',
                        data: JSON.stringify({
                            "firstName": $("#fname").val(),
                            "lastName": $("#lname").val(),
                            "address": $("#address").val(),
                            "phone": $("#phone").val(),
                            "email": $("#email").val(),\
                        "password": $("#password").val()}),
                        method: "put"
//                        success: function(result) {
//                        if(result === 1) 
//                            location.href = "index.html";
 //                   }
                    });
                });
            });
        </script>
    </head>
    <body>
         <h1>Update Books</h1>
        <section class="container">
            <div class="col-md-8">
                <form id="updateform">
                  
               
            

                                              
                <div class="form-group">
                    <label for="uid">ID:</label>
                    <input id="uid" readonly="readonly" class="form-control"/> 
                    <label for="fname">First Name:</label>
                    <input id="fname" class="form-control"/>
                    <label for="lname">Last Name:</label>
                    <input id="lname" class="form-control"/>
                    <label for="address">Address:</label>
                    <input id="address" class="form-control"/>
                    <label for="phone">Phone Number:</label>
                    <input id="phone" class="form-control"/>
                    <label for="email">Email:</label>
                    <input id="email" class="form-control"/>
                    <label for="password">Password:</label>
                    <input type="password" id="password" class="form-control"/>
                </div>

                <button id="update" class="btn btn-default">UPDATE</button>
                </form>
            </div>
        </section>
    </body>
</html>
