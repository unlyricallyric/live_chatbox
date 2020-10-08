package com.message.handler;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Message {

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time_string = utc.toLocalTime().format(formatter);
        LocalTime time = LocalTime.parse(time_string, formatter);
        return time;
    }

    public static void main(String args[]){
        ZonedDateTime utc1 = ZonedDateTime.now(ZoneOffset.UTC);
        LocalTime lt1 = utc1.toLocalTime();

        ZonedDateTime utc2;
        LocalTime lt2;

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } finally {
            utc2 = ZonedDateTime.now(ZoneOffset.UTC);
            lt2 = utc2.toLocalTime();
        }
        //later : 1, earlier : -1
        /*System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(lt1.compareTo(lt2));*/

        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time_string = utc.toLocalTime().format(formatter);
        LocalTime time = LocalTime.parse(time_string, formatter);

        System.out.println(time);
    }
}
