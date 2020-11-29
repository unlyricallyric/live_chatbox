package com.message.dao;

import com.message.model.Post;

import java.io.IOException;

public interface PostDao {
    int createPost(Post post);
    Post getSinglePost(int post_id);
    Post getRecentPost();
    String getAllPost(String user_group) throws IOException;
    int updatePost(String post_id, String post_title, String message);
    int deletePost(String post_id);
}
