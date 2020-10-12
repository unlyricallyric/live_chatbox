
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
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>

<head>
    <link rel="stylesheet" type="text/css" href="style1.css">
    <title>Title</title>

    <base href="<%=basePath%>">
    <title>Welcome to Chat Room</title>
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

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

<div class="container">
    <h1>Welcome to Chatting Room</h1>

    <div id="chatBox">

    </div><br>
    <%--<form id="messageForm">
        <label>Username：</label>
        <input id="user_name" type="text"/><br>
        <label>Text：</label>
        <input id="message" type="text"/><br>
        <button class="button" type="button" onclick="send()" >Send</button>
        <button class="button" type="button" onclick="clean()">Clear</button>
    </form><br>--%>

    <form>
        <label>Username：</label>
        <input id="user_name" name="user_name" type="text"/><br>
        <label>Text：</label>
        <input id="message" name="message" type="text"/><br>
        <%--<button type="submit" class="btn btn-primary">Submit</button>--%>
        <button class="button" type="button" onclick="send()" >Send</button>

    </form><br>

    <form>
        <label for="fname">From (Time):</label><br>
        <input type="time" step="1" ><br>
        <label for="lname">To (Time):</label><br>
        <input type="time" step="1">
        <div id="selectedMsg"></div><br>
        <input class = "button" type="submit" value="Filter">
        <button class="button" type="button" onclick="clean()" >Clean</button>
    </form><br>

    <form action="/action_page.php">

        <select>
            <option value="xml">xml</option>
            <option value="text">text</option>
        </select>
        <input class = "button" type="submit" value="Download">
    </form><br>

    <a href=" " onclick="changeCSS('style1.css', 0);">STYLE 1</a>
    <a href="#" onclick="changeCSS('style2.css', 0);">STYLE 2</a>

</div>
<script type="text/javascript">
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
</script>
</body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</html>
