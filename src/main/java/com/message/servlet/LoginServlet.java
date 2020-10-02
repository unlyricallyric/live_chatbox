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

        String fName = request.getParameter("f_name");
        String lName = request.getParameter("l_name");

        /*PrintWriter out = response.getWriter();
        out.println("Hello, "+fName + " " +lName);*/

        String url = "/index.jsp";
        request.setAttribute("first_name", fName);
        request.setAttribute("last_name", lName);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
