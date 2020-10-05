package com.message.handler;

public class User {
    private String username = "Anonymous";

    public User(String username){
        if(!username.isEmpty()) {
            setUsername(username);
        }
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }
}
