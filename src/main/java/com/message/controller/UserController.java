package com.message.controller;

import com.message.db.DBConnect;
import com.message.dao.UserDao;
import com.message.model.User;
import com.message.utils.BlogUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class UserController implements UserDao {

    private final String INSERT_USER = "INSERT INTO Users" +
            " (user_name, password, first_name, last_name, user_email, user_group) VALUES " + "(?, ?, ?, ?, ?, ?);";
    private final String FIND_USER = "SELECT password FROM Users where user_name=?;";
    private final String UPDATE_USER = "UPDATE Users SET password=?, first_name=?, last_name=?, user_email=? WHERE user_name=?;";
    private final String GET_USER_GROUP = "SELECT user_group FROM Users where user_name=?;";
    private final String GET_ALL_USER_GROUPS = "SELECT user_id, user_group FROM Users;";
    private final String GET_GROUP1 = "SELECT id, user_group FROM Group1;";
    private final String GET_GROUP2 = "SELECT id, user_group FROM Group2;";
    private final String GET_GROUP3 = "SELECT id, user_group FROM Group3;";

    private Connection con;

    public UserController() {
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
    public int createUser(User user) {
        int response_code = 0;

        try(PreparedStatement ps = con.prepareStatement(INSERT_USER)) {

            ps.setString(1, user.getUser_name());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirst_name());
            ps.setString(4, user.getLast_name());
            ps.setString(5, user.getUser_email());
            ps.setString(6, user.getUser_group());

            response_code = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return response_code;
    }

    @Override
    public boolean findUser(String username, String password) {
        String passFromDb="";

        try(PreparedStatement ps = con.prepareStatement(FIND_USER)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                passFromDb = rs.getString("password");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return passFromDb.equals(BlogUtil.passEncoding(password));
    }

    @Override
    public boolean updateUser(User user) {
        int success = 0;

        try(PreparedStatement ps = con.prepareStatement(UPDATE_USER)) {

            ps.setString(1, BlogUtil.passEncoding(user.getPassword()));
            ps.setString(2, user.getFirst_name());
            ps.setString(3, user.getLast_name());
            ps.setString(4, user.getUser_email());
            ps.setString(5, user.getUser_name());

            success = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return (1 == success);
    }

    @Override
    public String getUserGroup(String username) {
        String user_group = "";

        try(PreparedStatement ps = con.prepareStatement(GET_USER_GROUP)){
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                user_group = rs.getString("user_group");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return user_group;
    }

    @Override
    public LinkedHashMap getAllUserGroups() {
        LinkedHashMap<Integer, String> groups = new LinkedHashMap<>();

        try(PreparedStatement ps = con.prepareStatement(GET_ALL_USER_GROUPS)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int user_id = Integer.parseInt(rs.getString("user_id"));
                String user_group = rs.getString("user_group");
                groups.put(user_id, user_group);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return groups;
    }

    @Override
    public LinkedHashMap getGroup1() {
        LinkedHashMap<Integer, String> groups = new LinkedHashMap<>();

        try(PreparedStatement ps = con.prepareStatement(GET_GROUP1)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int user_id = Integer.parseInt(rs.getString("id"));
                String user_group = rs.getString("user_group");
                groups.put(user_id, user_group);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return groups;
    }

    @Override
    public LinkedHashMap getGroup2() {
        LinkedHashMap<Integer, String> groups = new LinkedHashMap<>();

        try(PreparedStatement ps = con.prepareStatement(GET_GROUP2)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int user_id = Integer.parseInt(rs.getString("id"));
                String user_group = rs.getString("user_group");
                groups.put(user_id, user_group);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return groups;
    }

    @Override
    public LinkedHashMap getGroup3() {
        LinkedHashMap<Integer, String> groups = new LinkedHashMap<>();

        try(PreparedStatement ps = con.prepareStatement(GET_GROUP3)){
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int user_id = Integer.parseInt(rs.getString("id"));
                String user_group = rs.getString("user_group");
                groups.put(user_id, user_group);
            }

        }catch(SQLException e){
            e.printStackTrace();
        }

        return groups;
    }
}
