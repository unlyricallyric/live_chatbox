<%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-09-25
  Time: 10:22 p.m.
  To change this template use File | Settings | File Templates. test
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import = "java.io.*,java.util.*,java.io.PrintWriter" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
<head>
    <title>Title</title>

    <base href="<%=basePath%>">
    <title>Welcome to Chat Room</title>
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet"   href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <style>
        body {
            margin: 0 auto;
            max-width: 800px;
            padding: 0 40px;
        }
        .container {
            border: 2px solid #dedede;
            background-color: #f1f1f1;
            border-radius: 30px;
            padding: 20px;
            margin: 10px 0;
        }
        #chatBox{
            background-color: #aba6bf;
            word-wrap: break-word;
            border:10px;
            solid: #00F;
            height: 200px;
            overflow-y: auto;
        }
        #selectedMsg{
            background-color: #aba6bf;
            word-wrap: break-word;
            border:10px;
            solid: #00F;
            height: 200px;
            overflow-y: auto;
        }
        input[type=text] {
            width: 100%;
            padding: 10px 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: none;
            background-color: #dfd7d7;
            color: black;
        }
        .button {
            display: inline-block;
            padding: 8px 10px;
            font-size: 12px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: white;
            background-color: #595775;
            border: none;
            border-radius: 13px;
            box-shadow: 0 3px #999;
        }
        .button:active {
            background-color: #595775;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }
        #div{
        }body {
             margin: 0 auto;
             max-width: 800px;
             padding: 0 40px;
         }
        .container {
            border: 2px solid #dedede;
            background-color: #f1f1f1;
            border-radius: 30px;
            padding: 20px;
            margin: 10px 0;
        }
        input[type=text] {
            width: 100%;
            padding: 10px 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: none;
            background-color: #dfd7d7;
            color: black;
        }
        .button {
            display: inline-block;
            padding: 8px 10px;
            font-size: 12px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: white;
            background-color: #595775;
            border: none;
            border-radius: 13px;
            box-shadow: 0 3px #999;
        }
        .button:active {
            background-color: #595775;
            box-shadow: 0 5px #666;
            transform: translateY(4px);
        }
        #div{
        }
    </style>
</head>

<body>
<%
    //PrintWriter pout = response.getWriter();
    //pout.println(session.getId());
%>
<div class="container">
    <h1>Welcome to Chatting Room</h1>

    <div id="chatBox">

    </div><br>
    <form id="messageForm">
        <label>Username：</label>
        <input id="user_name" type="text"/><br>
        <label>Text：</label>
        <input id="message" type="text"/><br>
        <button class="button" type="button" onclick="send()" >Send</button>
        <button class="button" type="button" onclick="clean()">Clear</button>

    </form><br>
    <form>
        <label for="fname">From (Time):</label><br>
        <input type="datetime-local" ><br>
        <label for="lname">To (Time):</label><br>
        <input type="datetime-local">
        <div id="selectedMsg"></div><br>
        <input class = "button" type="submit" value="Filter">
    </form><br>

    <form action="/action_page.php">

        <select>
            <option value="xml">xml</option>
            <option value="text">text</option>
        </select>
        <input class = "button" type="submit" value="Download">
    </form><br>
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
        //document.getElementById('chatBox').innerHTML += record;

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
        console.log(Object.keys(msg_db).length) ;
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
    function clean(){
        console.log(record);
        document.getElementById('/servlet/selectedMsg').innerHTML = "";
    }
</script>
</body>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</html>
