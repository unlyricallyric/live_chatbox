package com.message.controller;

import com.message.DB.DBConnect;
import com.message.Dao.UserDao;

import java.sql.*;
import java.util.Properties;

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
    public String findUser(int id) throws SQLException {
        String sql = "select * from Users where user_id=" + id;
        String name = "";

        System.out.println("client info: "+getCon().getClientInfo());
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
