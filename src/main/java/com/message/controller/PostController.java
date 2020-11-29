package com.message.controller;

import com.message.dao.PostDao;
import com.message.db.DBConnect;
import com.message.model.Post;
import com.message.utils.BlogUtil;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostController implements PostDao {

    private Connection con;

    private final String INSERT_POST = "INSERT INTO Posts" + " (posted_by, post_title, message, post_group) VALUES " + "(?, ?, ?, ?);";
    private final String DELETE_POST = "DELETE FROM Posts WHERE id = ?;";
    private final String UPDATE_POST = "UPDATE Posts Set post_title=?, message=? WHERE id=?";
    private final String GET_SINGLE_POST = "SELECT * FROM Posts WHERE id=?";
    private final String GET_ALL_POST = "SELECT * FROM Posts;";
    private final String GET_CONCORDIA_POST = "SELECT * FROM Posts where post_group IN('concordia','encs', 'comp', 'soen');";
    private final String GET_ENCS_POST = "SELECT * FROM Posts where post_group IN('encs', 'comp', 'soen');";
    private final String GET_COMP_POST = "SELECT * FROM Posts where post_group='comp';";
    private final String GET_SOEN_POST = "SELECT * FROM Posts where post_group='soen';";

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
    public int createPost(Post post) {
        int response_code = 0;

        try(PreparedStatement ps = con.prepareStatement(INSERT_POST)) {

            ps.setString(1, post.getPosted_by());
            ps.setString(2, post.getPost_title());
            ps.setString(3, post.getMessage());
            ps.setString(4, post.getPost_group());

            response_code = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response_code;
    }

    @Override
    public Post getSinglePost(int post_id) {
        /*Post post = null;

        try(PreparedStatement ps = con.prepareStatement(GET_SINGLE_POST)){
            ps.setInt(1, post_id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                String posted_by = rs.getString("posted_by");
                String post_title = rs.getString("post_title");
                String post_date = rs.getString("post_date");
                String last_modified = rs.getString("last_modified");
                String message = rs.getString("message");
                String post_group = rs.getString("post_group");
                post = new Post(post_id, posted_by, post_title, post_date, last_modified, message, post_group);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return post;*/
        return null;
    }

    @Override
    public Post getRecentPost() {
        return null;
    }

    @Override
    public String getAllPost(String user_group) throws IOException {
        List<Object> post_list = new ArrayList<>();
        String query = GET_ALL_POST;

        switch(user_group){
            case "concordia":
                query = GET_CONCORDIA_POST;
                break;
            case "encs":
                query = GET_ENCS_POST;
                break;
            case "comp":
                query = GET_COMP_POST;
                break;
            case "soen":
                query = GET_SOEN_POST;
                break;
        }

        try(PreparedStatement ps = con.prepareStatement(query)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int post_id = rs.getInt("id");
                String posted_by = rs.getString("posted_by");
                String post_title = rs.getString("post_title");
                String post_date = rs.getString("post_date");
                String last_modified = rs.getString("last_modified");
                String message = rs.getString("message");
                Post post = new Post(post_id, posted_by, post_title, post_date, last_modified, message, user_group);
                //PostJson postJson = new PostJson(post);
                post_list.add(post);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return BlogUtil.getJson(post_list);
    }

    @Override
    public int updatePost(String post_id, String post_title, String message) {
        int response_code = 0;

        try(PreparedStatement ps = con.prepareStatement(UPDATE_POST)){
            ps.setString(1, post_title);
            ps.setString(2, message);
            ps.setString(3, post_id);
            response_code = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }

        return response_code;
    }

    @Override
    public int deletePost(String post_id) {
        int response_code = 0;

        try(PreparedStatement ps = con.prepareStatement(DELETE_POST)){
            ps.setString(1, post_id);
            System.out.println(ps);
            response_code = ps.executeUpdate();
            System.out.println(" successfully deleted post " + post_id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return response_code;
    }
}
