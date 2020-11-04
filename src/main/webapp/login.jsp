<%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-10-01
  Time: 9:35 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/login.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Chat Room</title>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <form action="PosterServlet/read" method="POST" class="box">
                            <h1>Sign in</h1>
                                <input type="text" name="user_name" class="form-control" placeholder="Your Name " aria-describedby="basic-addon2">
                                <input class="btn btn-outline-secondary" type="submit">Login</input>
                            <div class="col-md-12">
                                <ul class="social-network social-circle">
                                    <li><a href="#" class="icoFacebook" title="Facebook"><i class="fab fa-facebook-f"></i></a></li>
                                    <li><a href="#" class="icoTwitter" title="Twitter"><i class="fab fa-twitter"></i></a></li>
                                    <li><a href="#" class="icoGoogle" title="Google +"><i class="fab fa-google-plus"></i></a></li>
                                </ul>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>