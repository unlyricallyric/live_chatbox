
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
<%@ page import="com.message.service.MessageService" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String style_sheet = request.getParameter("style_sheet");
    if(MessageService.isNullOrEmpty(style_sheet)){
        style_sheet = "style1.css";
    }
%>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="css/<%=style_sheet%>">
    <title>Title</title>

    <base href="<%=basePath%>">
    <title>Welcome to Chat Room</title>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

</head>

<body>

<%!
    //PrintWriter pout = response.getWriter();

    TreeMap<LocalTime, Message> msg_db = new TreeMap<>();
        String date, message, user;
%>

<div class="container">
    <h1 style="margin: auto; width: 30%; margin-bottom: 15px;font-family: Impact, Charcoal, sans-serif;">Chatting Time ${user_name}</h1>
    <div id="chatBox" class="alert alert-success">
        <%
            if(request.getAttribute("msg_db") != null) {
                msg_db = (TreeMap<LocalTime, Message>) request.getAttribute("msg_db");
                for (Map.Entry<LocalTime, Message> entry : msg_db.entrySet()) {
                    date = entry.getKey().toString();
                    user = entry.getValue().getUsername().toUpperCase();
                    message = entry.getValue().getMessage();
        %>

        <div class="alert alert-dark">
            <p> <%=user%> : <span style="float: right"><%=date%></span><p><%=message%> </p> </p>
        </div>

        <%
                }
            }
        %>
    </div><br>
    <form method="POST" action="MessageServlet">
        <label>Please Input Your Message : </label>
        <input type="hidden" name="user_name" value="${user_name}">
        <input type="hidden" name="style_sheet" value="${style_sheet}">
        <textarea id="text" class="form-control" name="message" rows="3"></textarea><br>
        <button type="submit" name="send" value="send" class="button">Send</button>
        <button type="submit" name="send" value="refresh" class="button">Refresh</button>
    </form>

    <form action="MessageServlet">
        <label>From :</label><br>
        <input type="text" name="from"><br>
        <label>To :</label><br>
        <input type="text" name="to"><br>
        <input type="hidden" name="user_name" value="${user_name}">
        <input type="hidden" name="style_sheet" value="${style_sheet}">
        <button type="submit" name="displayMessage" value="submit_show" class="button">Show Message</button>
        <button type="submit" name="displayMessage" value="submit_delete" class="button">Delete Message</button>
    </form><br>

    <form action="DownloadServlet">
        <select name="download">
            <option value="xml">xml</option>
            <option value="text">text</option>
        </select>
        <input class = "button" type="submit" value="Download">
    </form><br>

    <form method="POST" action="MessageServlet">
        <input type="hidden" name="send" value="refresh">
        <input type="hidden" name="user_name" value="${user_name}">
        <button type="submit" name="style_sheet" value="style1.css">STYLE 1</button>
        <button type="submit" name="style_sheet" value="style2.css">STYLE 2</button>
    </form>

</div>

<script>
    function changeCSS(cssFile, cssLinkIndex) {
        var oldlink = document.getElementsByTagName("link").item(cssLinkIndex);
        var newlink = document.createElement("link");
        newlink.setAttribute("rel", "stylesheet");
        newlink.setAttribute("type", "text/css");
        newlink.setAttribute("href", cssFile);
        document.getElementsByTagName("head").item(0).replaceChild(newlink, oldlink);
    }
</script>
<%--<script type="text/javascript">
    //send the msg to chat box
    function send(){
        //alert('Hello World!');
        var user_name = document.getElementById('user_name').value;
        var message = document.getElementById('message').value;
        var date = new Date();
        var time = date.getTime();
        var record = user_name + " said: " + message + " " + date + "<br>";
        document.getElementById('chatBox').innerHTML += record;
        //send the data to backend
        var xmlhttp;
        xmlhttp = new XMLHttpRequest();
        xmlhttp.open('POST', "MessageServlet", true);
        xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        var parameters;
        parameters = "user_name=" + user_name + "&message=" + message;
        //xmlhttp.open('GET', "MessageService?" + parameters, true)
        var msg_db;
        msg_db = xmlhttp.send(parameters);
        console.log(msg_db) ;
        //display(msg_db);
    }
    function display(msg_db){
        console.log(msg_db);
        var i;
        for(i = 0; i<msg_db.length;i++){
            console.log(msg_db[i]);
            document.getElementById('chatBox').innerHTML += msg_db[i];
        }
    }
    //clear the msg of the chat box
    //function clean(){
    //   console.log(record);
    //  document.getElementById('/servlet/selectedMsg').innerHTML = "";
    //}
    function clean(){
    }
    //change the style css
    function changeCSS(cssFile, cssLinkIndex) {
        var oldlink = document.getElementsByTagName("link").item(cssLinkIndex);
        var newlink = document.createElement("link");
        newlink.setAttribute("rel", "stylesheet");
        newlink.setAttribute("type", "text/css");
        newlink.setAttribute("href", cssFile);
        document.getElementsByTagName("head").item(0).replaceChild(newlink, oldlink);
    }
</script>--%>
</body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</html>
