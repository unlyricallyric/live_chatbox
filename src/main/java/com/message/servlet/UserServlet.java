package com.message.servlet;

import com.message.controller.UserController;

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
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response){
        System.out.println("this is Create");

        try{
            UserController uc = new UserController();
            //String user_name = uc.findUser(1);

            //System.out.println("the user name is: " + user_name);

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
