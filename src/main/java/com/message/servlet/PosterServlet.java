package com.message.servlet;

import com.message.controller.PostController;
import com.message.model.Post;
import com.message.model.User;
import com.message.controller.UserController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PosterServlet/*")
public class PosterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();

        System.out.println("this is the action: " + action);

        switch (action) {
            case "/create":
                createPost(request, response);
                break;
            case "/read":
                listPost(request, response);
                break;
            case "/update":
                updatePost(request, response);
                break;
            case "/delete":
                deletePost(request, response);
                break;
            default:
                listPost(request, response);
                break;
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");

        String posted_by = request.getParameter("posted_by");
        String post_title = request.getParameter("post_title");
        String post_message = request.getParameter("post_message");

        Post post = new Post(posted_by, post_title, post_message);

        try{
            PostController pc = new PostController();
            pc.createPost(post);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void listPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is Read");

        try{
            User user = new User(1);
            UserController uc = new UserController();
            String user_name = uc.findUser(user.getId());

            System.out.println("the user name is: " + user_name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is update");
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is delete");
    }
}
