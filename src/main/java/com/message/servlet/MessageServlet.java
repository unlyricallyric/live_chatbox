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

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
            Referer Check
         */
        String refererHeader = request.getContextPath();
        System.out.println("getHeader "+request.getHeader("referer"));
        System.out.println("getContextPath "+request.getContextPath());
        System.out.println("getPathInfo "+request.getPathInfo());
        System.out.println("getHttpServletMapping "+request.getHttpServletMapping());
        System.out.println("getRequestURI "+request.getRequestURI());
        System.out.println("getRequestURL "+request.getRequestURL());

        String message = request.getParameter("message");
        String user_name = request.getParameter("user_name");

        ChatManager.postMessage(user_name, message);

        /*====temporary for testing outcome====*/
        TreeMap<LocalTime, Message> msg_db;

        msg_db = ChatManager.ListMessages();

        PrintWriter out = response.getWriter();

        String msg_arr[][] = new String[100][4];
        int count = 0;

        for (LocalTime i : msg_db.keySet()){
            //out.println(msg_db.get(i).getDate());
            msg_arr[count++][0] = i.toString();
            //out.println(msg_db.get(i).getUsername());
            msg_arr[count++][1] = msg_db.get(i).getUsername();
            //out.println(msg_db.get(i).getMessage());
            msg_arr[count++][2] = msg_db.get(i).getMessage();
        }

        out.println(msg_arr.toString());
        /*====temporary for testing outcome====*/

        /*====keep for sending back message object to frontend====*/
        String url = "/index.jsp";
        request.setAttribute("msg_db", msg_db);
        request.setAttribute("msg_arr", msg_arr);
        request.setAttribute("user_name", user_name);

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get from and to params
        String str_from = request.getParameter("from");
        String str_to = request.getParameter("to");

        LocalTime from = (MessageService.isNullOrEmpty(str_from))?LocalTime.of(00,00,00):MessageService.getDateFromString(str_from);
        LocalTime to = (MessageService.isNullOrEmpty(str_to))?LocalTime.of(23,59,59):MessageService.getDateFromString(str_to);

        //TODO implement logic while only one of the range is given
        TreeMap<LocalTime, Message> msg_db;

        if(MessageService.isNullOrEmpty(str_from) && MessageService.isNullOrEmpty(str_to)){
            msg_db = ChatManager.ListMessages();
        }else{
            msg_db = ChatManager.ListMessages(from, to);
        }

        PrintWriter out = response.getWriter();

        for (LocalTime i : msg_db.keySet()){
            out.println(msg_db.get(i).getDate());
            out.println(msg_db.get(i).getMessage());
            out.println(msg_db.get(i).getUsername());
        }
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
