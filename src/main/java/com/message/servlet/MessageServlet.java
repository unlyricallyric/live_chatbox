package com.message.servlet;

import com.message.handler.ChatManager;
import com.message.handler.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.util.HashMap;

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        String user_name = request.getParameter("user_name");

        //For testing outcome
        /*ChatManager.postMessage(user_name, message);

        HashMap<String, String> new_db;

        ChatManager.postTestMessage(user_name, message);

        new_db = ChatManager.listTestMessage();

        PrintWriter out = response.getWriter();
        out.println(new_db.get(user_name));*/

        String url = "/index.jsp";
        request.setAttribute("message", message);
        request.setAttribute("user_name", user_name);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
