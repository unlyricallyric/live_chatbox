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
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <link href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%--        <link rel="stylesheet" type="text/css" href="css/<%=style_sheet%>">--%>
    <title>LOGIN</title>

    <%--        <base href="<%=basePath%>">--%>
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link rel="stylesheet" href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
</head>

<body>



<div id="container">
    <h1 style="text-align:center; color:white">LOGIN</h1><br>
    <div>
        <form action="#" method="post">
            <input class="text" type="name" name="name" placeholder="Name" required="">
            <input class="text" type="password" name="password" placeholder="Password" required=""><br><br>
            <button type="submit" name="login" value="submit_show" class="button">LOGIN</button>
        </form>
    </div><br>
    <p style="color: white">Don't Have an Account? <a href="sign_up.jsp"> Sign Up Now!</a></p>
    <p style="color: white"><a href="forget_password.jsp">Forget password?</a></p>

</div>


</body>
</html>