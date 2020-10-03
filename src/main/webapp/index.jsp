<%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-09-25
  Time: 10:22 p.m.
  To change this template use File | Settings | File Templates. test
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.io.PrintWriter" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<head>
    <title>Title</title>
</head>
<body>
    <%
        PrintWriter pout = response.getWriter();
        pout.println(session.getId());
    %>

    <div class="chatbox" style="width: 50%;margin: auto">
        <h1 style="width:30%;margin: auto">Chat Messages</h1>
        <h2>Hello,
            ${user_name}
        </h2>

        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">${user_name}:</h4>
            <p>${message}</p>
        </div>

        <form action="MessageServlet">
            <div class="form-group">
                Please enter your message here:
                <input type="hidden" name="user_name" value="${user_name}">
                <textarea class="form-control" name="message" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</body>
</html>
