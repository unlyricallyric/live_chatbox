package com.message.servlet;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        System.out.println("this is the action: " + action);

        try{
            switch (action) {
                case "/PosterServlet/create":
                    createPost(request, response);
                    break;
                case "/PosterServlet/read":
                    listPost(request, response);
                    break;
                case "/PosterServlet/update":
                    updatePost(request, response);
                    break;
                case "/PosterServlet/delete":
                    deletePost(request, response);
                    break;
                default:
                    listPost(request, response);
                    break;
            }
        }catch(SQLException ex){
            throw new ServletException(ex);
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");
    }

    private void listPost(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("this is Read");


        try{
            UserController uc = new UserController();
            String user_name = uc.findUser(1);

            System.out.println("the user name is: " + user_name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is update");
    }

    private void deletePost(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
        System.out.println("this is delete");
    }
}
