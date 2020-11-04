package com.message.controller;

import com.message.DB.DBConnect;
import com.message.Dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class UserController implements UserDao {

    public Connection con;

    public UserController(){

    }

    @Override
    public String findUser(int id) throws SQLException {
        String sql = "select * from Users where user_id=" + id;
        System.out.println("the sql statement is: " + sql);
        String name = "";


        try{
            DBConnect db = new DBConnect();
            con = getConnection();

            System.out.println(con.getClientInfo());

            /*Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                name = rs.getString("user_name");
            }*/

        } catch (Exception e) {

        }
        return name;
    }

    public Connection getConnection() throws SQLException {

        Connection conn;

        conn = DriverManager.getConnection("jdbc:mysql://192.99.246.175:3306/Blog", "root", "Concordia2020");

        System.out.println("Connected to database");
        return conn;
    }

    public static void main(String args[]){
        /*UserController uc = new UserController();
        try {
            System.out.println(uc.getConnection());
        }catch(Exception e){

        }*/
    }
}
