<%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-09-25
  Time: 10:22 p.m.
  To change this template use File | Settings | File Templates. test
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.io.PrintWriter" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="com.message.handler.Message" %>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<head>
    <title>Title</title>
</head>
<body>
    <%!
        //PrintWriter pout = response.getWriter();
        TreeMap<LocalTime, Message> msg_db = new TreeMap<>();
        String date;
    %>

    <%
        if(request.getAttribute("msg_db") != null) {
            msg_db = (TreeMap<LocalTime, Message>) request.getAttribute("msg_db");
            for (Map.Entry<LocalTime, Message> entry : msg_db.entrySet()) {
                date = entry.getKey().toString();
    %>
<%--                pout.println("<!DOCTYPE html>");--%>
<%--                pout.println("<html>");--%>
<%--                pout.println("<head>");--%>
<%--                pout.println("<title>Servlet HelloWorldServlet</title>");--%>
<%--                pout.println("</head>");--%>
<%--                pout.println("<body>");--%>
<%--                pout.println("<h1>Time : " + entry.getKey() + "</h1>");--%>
<%--                pout.println("<h3>User : " + entry.getValue().getUsername() + "</h3>");--%>
<%--                pout.println("<h3>Message : " + entry.getValue().getMessage() + "</h3>");--%>
<%--                pout.println("</body>");--%>
<%--                pout.println("</html>");--%>
                <p>Here goes testing messages: </p>
                <p>${date}</p>
                <p><%=date%></p>
                <p>${entry.getValue().getUsername()}</p>
                <p><%=entry.getValue().getUsername()%></p>
                <p>${entry.getValue().getMessage()}</p>
                <p><%=entry.getValue().getMessage()%></p>
    <%
            }
        }
    %>

    <div class="chatbox" style="width: 50%;margin: auto">
        <h1 style="width:40%;margin: auto">Chat Messages</h1>
        <h2>Hello,
            ${user_name}
        </h2>

        <div class="alert alert-success" role="alert">
            <h4 class="alert-heading">${user_name}:</h4>
            <p>${message}</p>
        </div>

        <form method="POST" action="MessageServlet">
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
