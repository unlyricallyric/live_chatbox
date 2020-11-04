package com.message.Model;

public class Post {

    private int id;
    private String posted_by;
    private String post_date;
    private String last_modified;
    private String message;

    public Post(int id, String posted_by){
        this.id = id;
        this.posted_by = posted_by;
    }

    public Post(int id, String posted_by, String post_date, String last_modified, String message){
        this(id, posted_by);
        this.post_date = post_date;
        this.last_modified = last_modified;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
