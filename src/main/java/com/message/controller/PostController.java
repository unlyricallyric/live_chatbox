package com.message.controller;

import com.message.dao.PostDao;
import com.message.db.DBConnect;
import com.message.model.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostController implements PostDao {

    private Connection con;

    private final String INSERT_POST = "INSERT INTO Posts" + " (posted_by, post_title, message) VALUES " + "(?, ?, ?);";

    public PostController(){
        try {
            DBConnect db = new DBConnect();
            setCon(db.getConnection());
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void setCon(Connection c){
        this.con = c;
    }

    public Connection getCon(){
        return this.con;
    }

    @Override
    public boolean createPost(Post post) {
        try {
            PreparedStatement ps = con.prepareStatement(INSERT_POST);
            ps.setString(1, post.getPosted_by());
            ps.setString(2, post.getPost_title());
            ps.setString(3, post.getMessage());
            System.out.println(ps);
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Post getRecentPost() {
        return null;
    }

    @Override
    public Post getAllPost() {
        return null;
    }

    @Override
    public boolean updatePost(int post_id) {
        return false;
    }

    @Override
    public boolean deletePost(int post_id) {
        return false;
    }
}
