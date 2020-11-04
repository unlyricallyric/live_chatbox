<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2020-11-02
  Time: 8:24 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<%--    <link rel="stylesheet" type="text/css" href="css/<%=style_sheet%>">--%>
    <title>Sign Up</title>
    <link rel="stylesheet" type="text/css" href="css/signup.css">
<%--    <base href="<%=basePath%>">--%>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>
<body>



<div id="container">
    <h1 style="text-align:center; color:white">SIGN UP</h1><br>
    <div>
        <form action="#" method="post">
            <input class="text" type="id" name="id" placeholder="ID" required="">
            <input class="text" type="text" name="Username" placeholder="Username" required="">
            <input class="text" type="email" name="email" placeholder="Email" required="">
            <input class="text" type="password" name="password" placeholder="Password" required=""><br><br>
            <button type="submit" name="SignUp" value="submit_show" class="button">Sign Up</button>
        </form>
    </div><br>
    <p style="color: white">Have an Account? <a href="login.jsp"> Login Now!</a></p>

</div>


</body>
</html>
