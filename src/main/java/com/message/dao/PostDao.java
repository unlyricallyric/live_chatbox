package com.message.dao;

import com.message.model.Post;

public interface PostDao {
    int createPost(Post post);
    Post getSinglePost(int post_id);
    Post getRecentPost();
    Post getAllPost();
    int updatePost(int post_id, String post_title, String message);
    int deletePost(int post_id);
}
