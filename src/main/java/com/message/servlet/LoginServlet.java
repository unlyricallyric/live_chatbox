package com.message.servlet;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import com.message.handler.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User(request.getParameter("user_name"));

        String url = "/index.jsp";
        request.setAttribute("user_name", user.getUsername());

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
