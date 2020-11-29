package com.message.model;

public class User {

    private int id;
    private String user_name;
    private String password;
    private String first_name = "";
    private String last_name = "";
    private String user_email = "";
    private String user_group = "encs";

    public User(int id){
        this.id = id;
    }

    public User(String user_name, String password, String first_name, String last_name, String user_email){
        this.user_name = user_name;
        this.password = password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_email = user_email;
    }

    public User(String user_name, String password, String first_name, String last_name, String user_email, String user_group){
        this(user_name, password, first_name, last_name, user_email);
        this.user_group = user_group;
    }

    public User(int id, String user_name, String password, String first_name, String last_name, String user_email, String user_group){
        this(user_name, password, first_name, last_name, user_email, user_group);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_group() {
        return user_group;
    }

    public void setUser_group(String user_group) {
        this.user_group = user_group;
    }

}
