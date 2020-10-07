package com.message.handler;

import java.time.*;

public class Message {

    private String userName;
    private String message;
    private LocalDateTime date;

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

    public LocalDateTime getDate(){
        return this.date;
    }

    public LocalDateTime getCurrentDate(){
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        return utc.toLocalDateTime();
    }

    public static void main(String args[]){
        ZonedDateTime utc1 = ZonedDateTime.now(ZoneOffset.UTC);
        LocalDateTime lt1 = utc1.toLocalDateTime();

        ZonedDateTime utc2;
        LocalDateTime lt2;

        try {
            Thread.sleep(2 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        } finally {
            utc2 = ZonedDateTime.now(ZoneOffset.UTC);
            lt2 = utc2.toLocalDateTime();
        }
        //later : 1, earlier : -1
        System.out.println(lt1);
        System.out.println(lt2);
        System.out.println(lt1.compareTo(lt2));
    }
}
