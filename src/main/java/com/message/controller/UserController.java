package com.message.controller;

import com.message.db.DBConnect;
import com.message.dao.UserDao;

import java.sql.*;

public class UserController implements UserDao {

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

    public static void main(String args[]){

    }
}
