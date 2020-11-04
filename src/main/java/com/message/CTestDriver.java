package com.message;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class CTestDriver
{
    public Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = CTestDriver.class.getClassLoader().getResourceAsStream(propFileName);
        
        try {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        String host_ip = prop.getProperty("host_ip");
        int db_port = Integer.parseInt(prop.getProperty("db_port"));
        String db = prop.getProperty("db");
        String db_user = prop.getProperty("db_user");
        String db_pass = prop.getProperty("db_pass");
        
        Connection con = DriverManager.getConnection("jdbc:mysql://" + host_ip + ":" + db_port + "/" + db, db_user, db_pass);
        System.out.println("jdbc:mysql://" + host_ip + ":" + db_port + "/" + db);
        return con;
    }

    public static void main(String[] args) throws SQLException {
        
        Connection con = null;
        CTestDriver ct = new CTestDriver();

        try {
            con = ct.getConnection();

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Persons");

            while (rs.next()) {
                String lastName = rs.getString("LastName");
                System.out.println(lastName + "\n");
            }
        }catch(Exception e){

        }finally {
            con.close();
        }
    }
}