package com.message.handler;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class ChatManager {

    //leave for later composition structure

    /*private final Message message;
    private final User user;

    public ChatManager(Message message, User user){
        this.message = message;
        this.user = user;
    }*/

    //local DB, save data in memory
    private static TreeMap<LocalTime, Message> DB = new TreeMap<>();

    public static void postMessage(String user_name, String message){
        Message m = new Message(new User(user_name), message);
        DB.put(m.getDate(), m);
    }

    public static TreeMap<LocalTime, Message> ListMessages(){
        return DB;
    }

    public static TreeMap<LocalTime, Message> ListMessages(LocalTime start, LocalTime end){
        TreeMap<LocalTime, Message> msgRange_DB = new TreeMap<>();

        for(LocalTime date : DB.keySet()){
            if(date.compareTo(start) == 1 && date.compareTo(end) == -1){
                msgRange_DB.put(date,DB.get(date));
            }
        }

        return msgRange_DB;
    }

    private void clearChat(){
        DB.clear();
    }

    private void clearChat(LocalTime from, LocalTime to){
        for(LocalTime date : DB.keySet()){
            if(date.compareTo(from) == 1 && date.compareTo(to) == -1){
                DB.remove(date);
            }
        }
    }

    public static void main(String args[]){

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);

        LocalTime date = utc.toLocalTime();

        System.out.println("DATETIME = " + date);

        System.out.println("hello");
    }
}
