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
import java.time.LocalDateTime;
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
        ChatManager.postMessage(user_name, message);

        HashMap<LocalDateTime, Message> msg_db;

        ChatManager.postTestMessage(user_name, message);

        msg_db = ChatManager.ListMessages();

        /*PrintWriter out = response.getWriter();
        out.println(msg_db);

        for (LocalDateTime i : msg_db.keySet()){
            out.println(msg_db.get(i).getDate());
            out.println(msg_db.get(i).getMessage());
            out.println(msg_db.get(i).getUsername());
        }*/

        String url = "/index.jsp";
        request.setAttribute("msg_db", msg_db);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
