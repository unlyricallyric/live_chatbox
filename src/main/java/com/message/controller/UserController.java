package com.message.controller;

import com.message.db.DBConnect;
import com.message.dao.UserDao;
import com.message.model.User;

import java.sql.*;

public class UserController implements UserDao {

    private final String INSERT_USER = "INSERT INTO Users" +
            " (user_name, password, first_name, last_name, user_email) VALUES " + "(?, ?, ?, ?, ?);";

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

            response_code = ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }
        return response_code;
    }

    @Override
    public String findUser(int id) {
        String sql = "select * from Users where user_id=" + id;
        String name = "";
        try{

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                name = rs.getString("user_name");
            }

        } catch (Exception e) {

        }
        return name;
    }
}
