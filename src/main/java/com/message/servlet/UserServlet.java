package com.message.servlet;

import com.message.controller.UserController;
import com.message.model.User;
import com.message.utils.BlogUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet("/UserServlet/*")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
                case "/login":
                    userLogin(request, response);
                    break;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void userLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String url = "";
        String err_message = "Either username or password is invalid! Please try again!";
        boolean validate_user = false;
        PrintWriter pw = response.getWriter();

        try{
            UserController uc = new UserController();
            validate_user = uc.findUser(username, password);
            request.setAttribute("validate_user", validate_user);

            if(validate_user){
                pw.print("User successfully validated!");
                url = "/index_blog.jsp";
                System.out.println("User successfully validated!");

            }else{
                pw.print("Username or password is wrong!");
                url = "/login.jsp";
                System.out.println("Wrong username or password!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }finally{
            System.out.println("url : " + url);
            request.setAttribute("err_message", err_message);
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = BlogUtil.passEncoding(request.getParameter("password"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String user_group = (request.getParameter("admin_user") == null)?"0":"1";

        User user = new User(username, password, firstname, lastname, email, user_group);
        try{
            UserController uc = new UserController();
            uc.createUser(user);
            BlogUtil.printMessage(response,"User successfully created! Redirecting to home page in 2 s.");

            String url = "/index_blog.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = BlogUtil.passEncoding(request.getParameter("password"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");

        User user = new User(username, password, firstname, lastname, email);

        try{
            UserController uc = new UserController();
            uc.updateUser(user);
            System.out.println("User successfully updated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
