package com.message.service;

import com.message.handler.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class MessageService {

    public static LocalTime getDateFromString(String str_date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime date = LocalTime.parse(str_date, formatter);
        return date;
    }

    public static TreeMap<LocalTime, Message> getMsgWithRange(TreeMap DB, LocalTime from, LocalTime to){
        return DB;
    }

    //check if msg is empty or null
    public static boolean isNullOrEmpty(String str){
        return (str == null || str.trim().isEmpty());
    }

    public static void csrfValidate(String referer, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //return referer.startsWith("http://localhost:8080");
        if(!referer.startsWith("http://localhost:8080")) {
            request.getServletContext()
                    .getRequestDispatcher("/error_handling/error-404.jsp")
                    .forward(request, response);
        }
    }

    public static void main(String[] arg){
    }
}
