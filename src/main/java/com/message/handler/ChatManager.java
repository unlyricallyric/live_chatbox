package com.message.handler;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;

public class ChatManager {

    //leave for later composition structure

    /*private final Message message;
    private final User user;

    public ChatManager(Message message, User user){
        this.message = message;
        this.user = user;
    }*/

    //local DB, save data in memory
    private static HashMap<LocalTime, Message> DB = new HashMap<>();

    private void PostMessage(String user, String message){
        Message m = new Message(new User(user), message);
        DB.put(m.getDate(), m);
    }

    private HashMap<LocalTime, Message> ListMessages(Date... date){
        //TODO get messages within date range
        return DB;
    }

    private void ClearChat(Date... date){
        DB.clear();
    }

    public static void main(String args[]){

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);

        LocalTime date = utc.toLocalTime();

        System.out.println("DATETIME = " + date);

        System.out.println("hello");
    }
}
