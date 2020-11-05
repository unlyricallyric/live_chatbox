package com.message.dao;

import com.message.model.Post;

public interface PostDao {
    boolean createPost(Post post);
    Post getRecentPost();
    Post getAllPost();
    boolean updatePost(int post_id);
    boolean deletePost(int post_id);
}
