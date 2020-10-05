package com.message.handler;

import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

class Message {

    private String userName;
    private String message;
    private LocalTime date;

    public Message(User user, String message){
        this.userName = user.getUsername();
        this.message = message;
        this.date = getCurrentDate();
    }

    public String getUsername(){
        return this.userName;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalTime getDate(){
        return this.date;
    }

    public LocalTime getCurrentDate(){
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        return utc.toLocalTime();
    }
}
