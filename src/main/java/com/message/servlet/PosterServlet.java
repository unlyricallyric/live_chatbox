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
import javax.servlet.http.HttpSession;

@WebServlet("/PosterServlet/*")
public class PosterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();

        switch (action) {
            case "/createPost":
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
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response){

        String posted_by = request.getParameter("posted_by");
        String post_title = request.getParameter("post_title");
        String post_message = request.getParameter("post_message");
        String post_group = request.getParameter("post_group");

        Post post = new Post(posted_by, post_title, post_message, post_group);

        try{
            PostController pc = new PostController();
            pc.createPost(post);
            String url = "/index_blog.jsp";
            response.sendRedirect(url);
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getAllPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String user_group = (String) session.getAttribute("user_group");

        try{
            PostController pc = new PostController();
            String result = pc.getAllPost(user_group);
            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response){

        String delete = request.getParameter("delete");
        String update = request.getParameter("update");

        String command = (delete!=null)?delete:update;

        String post_id = request.getParameter("post_id");
        String post_title = request.getParameter("post_title");
        String post_message = request.getParameter("post_message");

        try{
            PostController pc = new PostController();

            switch(command){
                case "delete":
                    pc.deletePost(response, post_id);
                    break;
                case "update":
                    pc.updatePost(response, post_id, post_title, post_message);
                    break;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
