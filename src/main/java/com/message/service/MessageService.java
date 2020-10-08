package com.message.service;

import com.message.handler.Message;

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
}
