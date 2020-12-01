package com.message.dao;

import com.message.model.Post;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public interface PostDao {
    int createPost(Post post);
    String getAllPost(String user_group) throws IOException;
    void updatePost(HttpServletResponse response, String post_id, String post_title, String message);
    void deletePost(HttpServletResponse response, String post_id);
}
