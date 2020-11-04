<%--
  Created by IntelliJ IDEA.
  User: SAMSUNG
  Date: 2020-11-02
  Time: 8:47 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - A Blog Lights Up Your Life</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/clean-blog.min.css" rel="stylesheet">

    <!-- added css -->
    <link href="css/commom.css" rel="stylesheet">
</head>
<body>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="index_blog.jsp">Update Post</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="index_blog.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="modify_account.jsp">Modify Account</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Sign Out</a>
                </li>

            </ul>
        </div>
    </div>
</nav>

<!-- Page Header -->
<header class="masthead" style="background-image: url('img/home-bg.jpg')">
    <div class="overlay"></div>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <div class="site-heading">
                    <h1>Clean Blog</h1>
                    <span class="subheading">Update Your Post</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div class="container">
    <div class="row">

        <div id="container">
            <h1 style="text-align: center;">Update Post</h1><br>

            <form method="POST" action="MessageServlet">
                <input type="hidden" name="user_name" value="${user_name}">
                <input type="hidden" name="style_sheet" value="${style_sheet}">
                <label>Original Title :</label><br>
                <input class="text" type="text" name="title" placeholder="Title required" required=""><br><br>
                <label>Update Text Here :</label><br>
                <textarea id="text" class="form-control" name="text" rows="3"></textarea><br>
                <input type="checkbox" id="attachment" name="attachment" value="Attachment">
                <label for="attachment">Attachment</label><br><br>
                <button type="submit" name="update" value="update" class="button">Update</button>
            </form>
        </div><br>

    </div>
</div>

<hr>

<!-- Footer -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <ul class="list-inline text-center">
                    <li class="list-inline-item">
                        <a href="create_post.jsp">
                            Create Post
                        </a>
                    </li>
                    <li class="list-inline-item">
                        <a href="update_post.jsp">
                            Update Post
                        </a>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</footer>

<!-- Bootstrap core JavaScript -->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom scripts for this template -->
<script src="js/clean-blog.min.js"></script>

</body>
</html>
