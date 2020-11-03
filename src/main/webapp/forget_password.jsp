<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2020-11-02
  Time: 8:49 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    <link rel="stylesheet" type="text/css" href="css/<%=style_sheet%>">--%>
    <title>Reset Password</title>

        <%--    added css--%>
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <%--    <base href="<%=basePath%>">--%>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>



<div id="container">
    <h1 style="text-align:center; color:white">RESET PASSWORD</h1><br>
    <div>
        <form action="#" method="post">
            <label style="color:white">Name :</label><br>
            <input class="text" type="name" name="name" placeholder="Name" required=""><br><br>
            <label style="color:white">New Password :</label><br>
            <input class="text" type="password" name="password" placeholder="Password" required=""><br><br>
            <button type="submit" name="login" value="submit_show" class="button">Reset</button>
        </form>
    </div><br>
    <p style="color: white">Go Back? <a href="login.jsp">Login Now!</a></p>
</div>


</body>
</html>
