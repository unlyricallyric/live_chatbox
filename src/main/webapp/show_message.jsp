<%@ page import="java.time.LocalTime" %>
<%@ page import="com.message.handler.Message" %>
<%@ page import="java.util.TreeMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-10-12
  Time: 4:10 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <title>Message History</title>
</head>
<body>

<div>
    <h1 id="title" style="margin:auto;width: 10%">Chat History</h1>
</div>

<div style="width: 40%; margin:auto;">
    <%!
        TreeMap<LocalTime, Message> msg_db = new TreeMap<>();
            String showDate, showUser, showMsg;
    %>
    <%
        if(request.getAttribute("msg_db") != null) {
            msg_db = (TreeMap<LocalTime, Message>) request.getAttribute("msg_db");
            for (Map.Entry<LocalTime, Message> entry : msg_db.entrySet()) {
                showDate = entry.getKey().toString();
                showUser = entry.getValue().getUsername().toUpperCase();
                showMsg = entry.getValue().getMessage();
    %>
    <div class="alert alert-dark">
        <p> <%=showUser%> : <span style="float: right"><%=showDate%></span><p><%=showMsg%> </p> </p>
    </div>
    <%
            }
        }
    %>
</div>
</body>
</html>
