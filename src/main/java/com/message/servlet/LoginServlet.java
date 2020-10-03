package com.message.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*@WebServlet(name = "com.message.servlet.LoginServlet")*/
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_name = "Anonymous";

        //String user_name = request.getParameter("user_name");

        if(!request.getParameter("user_name").isEmpty()){
            user_name = request.getParameter("user_name");
        }

        String url = "/index.jsp";
        request.setAttribute("user_name", user_name);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
