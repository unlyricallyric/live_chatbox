<%--
  Created by IntelliJ IDEA.
  User: johnsonhao
  Date: 2020-10-31
  Time: 12:20 p.m.
  To change this template use File | Settings | File Templates.
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
<html lang="en">

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
    <link href="css/index_blog.css" rel="stylesheet">
</head>

<body onload="my_function()">

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="index_blog.jsp">Home</a>
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
                    <span class="subheading">A Blog Light up Your Life</span>
                </div>
            </div>
        </div>
    </div>
</header>

<!-- Main Content -->
<div id= "outContainer">
    
	
	<!-- recent post box -->
	<div id="recentPost"> 
		<h1 style="text-align: center; padding-top: 5px;">Recent Posts:</h1><br>
		
	</div>
	
	<div id="allPosts">
		<!-- all posts box -->
		<h1 style="text-align: center;padding-top: 5px;">All Posts:</h1><br>
		<div id="chatBox" class="col-lg-8 col-md-10 mx-auto">
			<div class="post-preview">
				<a href="post.jsp">
					<h2 class="post-title">
						Man must explore, and this is exploration at its greatest
					</h2>
					<h3 class="post-subtitle">
						Problems look mighty small from 150 miles up
					</h3>
				</a>
				<p class="post-meta">Posted by
					<a href="#">Start Bootstrap</a>
					on September 24, 2019</p>
				<form action="DownloadServlet">
					<div class="row">
						<div id="download">
							<div class="col-md-2">
								<select name="download" class="form-control">
									<option value="text" selected="selected">text</option>
									<option value="xml">xml</option>
								</select>
								<input class="button" type="submit" value="Download">
							</div>
						</div>
					</div>
				</form><br>
			</div>
			<hr>
			<div class="post-preview">
				<a href="post.jsp">
					<h2 class="post-title">
						I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.
					</h2>
				</a>
				<p class="post-meta">Posted by
					<a href="#">Start Bootstrap</a>
					on September 18, 2019</p>
			</div>
			<hr>
			<div class="post-preview">
				<a href="post.jsp">
					<h2 class="post-title">
						Science has not yet mastered prophecy
					</h2>
					<h3 class="post-subtitle">
						We predict too much for the next year and yet far too little for the next ten.
					</h3>
				</a>
				<p class="post-meta">Posted by
					<a href="#">Start Bootstrap</a>
					on August 24, 2019</p>
			</div>
			<hr>
			<div class="post-preview">
				<a href="post.jsp">
					<h2 class="post-title">
						Failure is not an option
					</h2>
					<h3 class="post-subtitle">
						Many say exploration is part of our destiny, but it’s actually our duty to future generations.
					</h3>
				</a>
				<p class="post-meta">Posted by
					<a href="#">Start Bootstrap</a>
					on July 8, 2019</p>
			</div>
			<hr>
		   
		</div><br>

		<!-- search or delect form -->
		<div id="container">
			<h1 style="text-align: center;">Search or Delete</h1><br>

			<form action="MessageServlet">
				<label>Title :</label><br>
				<input class="text" type="text" name="title" placeholder="Title required" required=""><br><br>
				<input type="hidden" name="user_name" value="${user_name}">
				<input type="hidden" name="style_sheet" value="${style_sheet}"><br>
				<button type="submit" name="displayMessage" value="search" class="button">Search</button>
				<button type="submit" name="displayMessage" value="delete" class="button">Delete</button>
			</form>

			<div id="displayBox"></div>
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

<script type="text/javascript">
    function getJsonInfo(item) {
        var mp = new Map();
        for (var key in item) {
            mp.set(key,item[key]);
        }
        return mp;
    }

    function my_function() {
        //var mp = new Map();
        $.ajax({
            //url:"PosterServlet/getAllPost",
            url:"JsonServlet",
            data:{},
            type:"get",
            dataType:"json",
            success:function(data){
                var postInfo = data.map(getJsonInfo);
                $("#Message-1").text(postInfo[0].get("message"));
                $("#Date-1").text(postInfo[0].get("post_date"));
                $("#Author-1").text(postInfo[0].get("posted_by"));

                $("#Message-2").text(postInfo[1].get("message"));

            }
        })
    }
</script>

<script>
    setTimeout("my_function();",10000);
</script>
</body>
</html>
