package com.message.servlet;

import com.message.controller.UserController;
import com.message.model.User;
import com.message.utils.BlogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/UserServlet/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getPathInfo();

        try {
            switch (action) {
                case "/create":
                    createUser(request, response);
                    break;
                case "/update":
                    updateUser(request, response);
                    break;
                case "/delete":
                    deleteUser(request, response);
                    break;
                case "/login":
                    userLogin(request, response);
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validate_user = false;

        try{
            UserController uc = new UserController();
            validate_user = uc.findUser(username, password);
            if(validate_user){
                System.out.println("User successfully validated!");
            }else{
                System.out.println("Wrong username or password!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");
        String username = request.getParameter("username");
        String password = BlogUtil.passEncoding(request.getParameter("password"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");

        User user = new User(username, password, firstname, lastname, email);
        try{
            UserController uc = new UserController();
            uc.createUser(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");
    }
}
