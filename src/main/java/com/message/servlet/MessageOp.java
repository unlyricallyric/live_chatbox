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
import java.time.LocalTime;
import java.util.TreeMap;

@WebServlet("/MessageOp")
public class MessageOp extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user_name = request.getParameter("user_name");
        String message = request.getParameter("message");

        ChatManager.postMessage(user_name, message);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get from and to params
        String str_from = request.getParameter("from");
        String str_to = request.getParameter("to");

        LocalTime from = (MessageService.isNullOrEmpty(str_from))?LocalTime.of(00,00,00):MessageService.getDateFromString(str_from);
        LocalTime to = (MessageService.isNullOrEmpty(str_to))?LocalTime.of(23,59,59):MessageService.getDateFromString(str_to);

        TreeMap<LocalTime, Message> msg_db = ChatManager.ListMessages(from, to);

        PrintWriter out = response.getWriter();
        String date, user, msg;

        out.println("{");
        for (LocalTime i : msg_db.keySet()) {
            date = i.toString();
            user = msg_db.get(i).getUsername();
            msg = msg_db.get(i).getMessage();
            out.println("\t\"message\": {");
            out.println("\t\t\"date\": "+date+",");
            out.println("\t\t\"user\": "+user+",");
            out.println("\t\t\"msg\": "+msg+"");
            out.println("\t}");
        }
        out.println("}");
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
