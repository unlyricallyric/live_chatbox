package com.message.servlet;

import com.message.controller.PostController;
import com.message.model.Post;
import com.message.model.User;
import com.message.controller.UserController;
import com.message.utils.BlogUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            case "/getPost":
                getSinglePost(request, response);
                break;
            case "/getAllPost":
                getAllPost(request, response);
                break;
            case "/update":
                updatePost(request, response);
                break;
            case "/delete":
                deletePost(request, response);
                break;
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response){

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

    private void getSinglePost(HttpServletRequest request, HttpServletResponse response) {

        try{
            PostController pc = new PostController();
            Post post = pc.getSinglePost(4);

            System.out.println(post.getPosted_by());
            System.out.println(post.getPost_title());
            System.out.println(post.getMessage());


            //response.getWriter().write(BlogUtil.getJsonObject(post).toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllPost(HttpServletRequest request, HttpServletResponse response) {

        try{
            PostController pc = new PostController();
            String result = pc.getAllPost();

            System.out.println(result);
            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response){

        String post_id = request.getParameter("post_id");
        String post_title = request.getParameter("post_title");
        String message = request.getParameter("message");

        try{
            PostController pc = new PostController();
            pc.updatePost(post_id, post_title, message);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response){

        String post_id = request.getParameter("post_id");

        try{
           PostController pc = new PostController();
           pc.deletePost(post_id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
