package com.message.handler;

import com.message.service.MessageService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
        System.out.println(DB);
        return DB;
    }

    public static TreeMap<LocalTime, Message> ListMessages(LocalTime start, LocalTime end){
        TreeMap<LocalTime, Message> msgRange_DB = new TreeMap<>();

        for(LocalTime date : DB.keySet()){
            if(date.compareTo(start) >= 0 && date.compareTo(end) <= 0){
                msgRange_DB.put(date,DB.get(date));
            }
        }

        return msgRange_DB;
    }

    public static void clearChat(){
        DB.clear();
    }
    public static void clearChat(LocalTime start, LocalTime end){

        DB.entrySet()
                .removeIf(
                        entry -> (entry.getKey().compareTo(start) >= 0 && entry.getKey().compareTo(end) <= 0)
                );
    }

    public static void main(String args[]){

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);

        LocalTime date = utc.toLocalTime();

        System.out.println("DATETIME = " + date);

        System.out.println("hello");

        LocalTime time = LocalTime.of(10,43,11);
        LocalTime time1 = LocalTime.of(10,43,12);
        System.out.println(time.compareTo(time1));

        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(3, "val3");
        map.put(2, "val2");
        map.put(1, "val1");
        map.put(5, "val5");
        map.put(4, "val4");

        map.remove(2);
        map.remove(4);

        for(Integer i : map.keySet()){
            System.out.println(map.get(i));
        }


    }
}
