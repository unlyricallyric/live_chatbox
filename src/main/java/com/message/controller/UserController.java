package com.message.controller;

import com.message.db.DBConnect;
import com.message.dao.UserDao;
import com.message.model.User;
import com.message.utils.BlogUtil;

import java.sql.*;

public class UserController implements UserDao {

    private final String INSERT_USER = "INSERT INTO Users" +
            " (user_name, password, first_name, last_name, user_email, user_group) VALUES " + "(?, ?, ?, ?, ?, ?);";
    private final String FIND_USER = "SELECT password FROM Users where user_name=?;";
    private final String UPDATE_USER = "UPDATE Users SET password=?, first_name=?, last_name=?, user_email=? WHERE user_name=?;";

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
}
