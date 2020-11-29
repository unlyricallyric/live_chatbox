package com.message.model;

public class Post {

    protected int id;
    protected String posted_by;
    protected String post_title;
    protected String post_date;
    protected String last_modified;
    protected String message;
    protected String post_group;

    public Post(String posted_by, String post_title, String message){
        this.posted_by = posted_by;
        this.post_title = post_title;
        this.message = message;
    }

    public Post(String posted_by, String post_title, String message, String post_group){
        this(posted_by, post_title, message);
        this.post_group = post_group;
    }

    public Post(String posted_by, String post_title, String post_date, String last_modified, String message, String post_group){
        this.posted_by = posted_by;
        this.post_title = post_title;
        this.post_date = post_date;
        this.last_modified = last_modified;
        this.message = message;
        this.post_group = post_group;
    }

    public Post(int id, String posted_by, String post_title, String post_date, String last_modified, String message, String post_group){
        this(posted_by, post_title, post_date, last_modified, message, post_group);
        this.id = id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPost_group() {
        return post_group;
    }

    public void setPost_group(String post_group) {
        this.post_group = post_group;
    }

    public String getPosted_by() {
        return posted_by;
    }

    public void setPosted_by(String posted_by) {
        this.posted_by = posted_by;
    }

    public String getPost_date() {
        return post_date;
    }

    public void setPost_date(String post_date) {
        this.post_date = post_date;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(String last_modified) {
        this.last_modified = last_modified;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
