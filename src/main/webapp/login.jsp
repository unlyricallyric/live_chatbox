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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Title</title>
</head>
<body>
    <form action="LoginServlet" method="POST" style="position: absolute;top: 40%;left: 40%;">
        <%--<div class="form-row">
            <div class="col">
                <input type="text" name="user_name" class="form-control" placeholder="Please enter your name: ">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>--%>
        <div class="input-group">
            <input type="text" name="user_name" class="form-control" placeholder="Your Name " aria-describedby="basic-addon2">
            <div class="input-group-append">
                <button class="btn btn-outline-secondary" type="submit">Login</button>
            </div>
        </div>
    </form>
</body>
</html>
