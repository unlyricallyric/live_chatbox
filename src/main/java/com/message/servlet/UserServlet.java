package com.message.servlet;

import com.message.controller.UserController;
import com.message.model.User;
import com.message.utils.BlogUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
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
                case "/signout":
                    userSignout(request, response);
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
        HttpSession session = request.getSession();
        boolean validate_user = false;

        try{
            UserController uc = new UserController();
            validate_user = uc.findUser(username, password);
            request.setAttribute("validate_user", validate_user);

            if(validate_user){
                url = "/index_blog.jsp";
                session.setAttribute("username", username);
                session.setAttribute("user_authentication", true);
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);

            }else{
                url = "/login.jsp";
                session.setAttribute("err_message", err_message);
                response.sendRedirect(url);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void userSignout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("im signing out!");
        HttpSession session = request.getSession();
        session.removeAttribute("user_authentication");
        session.removeAttribute("username");
        session.invalidate();

        String url = "/login.jsp";
        response.sendRedirect(url);
    }

    private void createUser(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = BlogUtil.passEncoding(request.getParameter("password"));
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String user_group = request.getParameter("group");

        User user = new User(username, password, firstname, lastname, email, user_group);
        try{
            UserController uc = new UserController();
            uc.createUser(user);
            BlogUtil.printMessage(response,"User successfully created! Redirecting to home page in 2 s.");

            String err_message = "You have successfully registered, please login";

            String url = "/login.jsp";
            session.setAttribute("err_message",err_message);
            response.sendRedirect(url);

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
