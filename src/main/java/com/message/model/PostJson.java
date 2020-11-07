package com.message.model;

public class PostJson {
    Post post;

    public PostJson(Post post_value){
        this.post = post_value;
    }

    public Post getPost_value() {
        return post;
    }

    public void setPost_value(Post post_value) {
        this.post = post_value;
    }
}
