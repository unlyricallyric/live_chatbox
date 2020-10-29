package com.message.servlet;

import com.message.handler.ChatManager;
import com.message.handler.Message;
import com.message.service.MessageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.time.LocalTime;
import java.util.TreeMap;

@WebServlet("/MessageServlet/*")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            Referer Check
         */
        String refererHeader = request.getHeader("referer");
        MessageService.csrfValidate(refererHeader, request, response);

        String refresh = request.getParameter("send");
        String user_name = request.getParameter("user_name");
        String message = request.getParameter("message");
        String style_sheet = request.getParameter("style_sheet");

        /*
            DB Connection
         */
        Connection con;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost";
            String user = "";
            String pass = "";
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TreeMap<LocalTime, Message> msg_db;

        if(refresh.equals("refresh")){
            msg_db = ChatManager.ListMessages();
        }else {

            ChatManager.postMessage(user_name, message);

            msg_db = ChatManager.ListMessages();

            PrintWriter out = response.getWriter();

            String msg_arr[][] = new String[100][4];
            int count = 0;

            for (LocalTime i : msg_db.keySet()) {
                msg_arr[count++][0] = i.toString();
                msg_arr[count++][1] = msg_db.get(i).getUsername();
                msg_arr[count++][2] = msg_db.get(i).getMessage();
            }
        }

        /*====keep for sending back message object to frontend====*/
        String url = "/index.jsp";
        request.setAttribute("msg_db", msg_db);
        request.setAttribute("user_name", user_name);
        request.setAttribute("style_sheet", style_sheet);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            Referer Check
         */
        String refererHeader = request.getHeader("referer");
        MessageService.csrfValidate(refererHeader, request, response);

        //get from and to params
        String str_from = request.getParameter("from");
        String str_to = request.getParameter("to");
        String user_name = request.getParameter("user_name");
        String style_sheet = request.getParameter("style_sheet");

        LocalTime from = (MessageService.isNullOrEmpty(str_from))?LocalTime.of(00,00,00):MessageService.getDateFromString(str_from);
        LocalTime to = (MessageService.isNullOrEmpty(str_to))?LocalTime.of(23,59,59):MessageService.getDateFromString(str_to);

        //TODO implement logic while only one of the range is given
        TreeMap<LocalTime, Message> msg_db;

        String msg_req = request.getParameter("displayMessage");
        String url = "";

        if(msg_req.equals("submit_delete")){
            url = "/index.jsp";
            ChatManager.clearChat(from, to);
        }else{
            url = "/show_message.jsp";
        }

        if(MessageService.isNullOrEmpty(str_from) && MessageService.isNullOrEmpty(str_to)){
            msg_db = ChatManager.ListMessages();
        }else{
            msg_db = ChatManager.ListMessages(from, to);
        }

        request.setAttribute("msg_db", msg_db);
        request.setAttribute("user_name", user_name);
        request.setAttribute("style_sheet", style_sheet);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);

    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get from and to params
        String str_from = request.getParameter("from");
        String str_to = request.getParameter("to");

        LocalTime from = (MessageService.isNullOrEmpty(str_from))?LocalTime.of(00,00,00):MessageService.getDateFromString(str_from);
        LocalTime to = (MessageService.isNullOrEmpty(str_to))?LocalTime.of(23,59,59):MessageService.getDateFromString(str_to);

        if(MessageService.isNullOrEmpty(str_from) && MessageService.isNullOrEmpty(str_to)){
            ChatManager.clearChat();
        }else{
            ChatManager.clearChat(from, to);
        }
    }


}
