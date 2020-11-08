package com.message.model;

public class PostJson {
    Post post;

    public PostJson(Post post){
        this.post = post;
    }

    public Post getPost_value() {
        return post;
    }

    public void setPost_value(Post post) {
        this.post = post;
    }
}
