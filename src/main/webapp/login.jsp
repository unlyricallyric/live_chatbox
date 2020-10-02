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
<form action="com/message/servlet/LoginServlet" method="GET" style="width: 20%;margin: auto">
    <div class="form-row">
        <div class="col">
            <input type="text" name="f_name" class="form-control" placeholder="First name">
        </div>
        <div class="col">
            <input type="text" name="l_name" class="form-control" placeholder="Last name">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
