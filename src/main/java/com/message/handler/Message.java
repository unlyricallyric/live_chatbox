package com.message.handler;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.message.handler.Message.openSSH;

public class Message {

    private String userName;
    private String message;
    private LocalTime date;

    String result = "";
    InputStream inputStream;

    private static Session session;

    private final static Logger LOGGER =
            Logger.getLogger(Message.class.getName());

    public Message(User user, String message){
        this.userName = user.getUsername();
        this.message = message;
        this.date = getCurrentDate();
    }

    public String getUsername(){
        return this.userName;
    }

    public String getMessage(){
        return this.message;
    }

    public LocalTime getDate(){
        return this.date;
    }

    public LocalTime getCurrentDate(){
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time_string = utc.toLocalTime().format(formatter);
        LocalTime time = LocalTime.parse(time_string, formatter);
        return time;
    }

    public static Connection getConnection(){
        Connection conn = null;
        try {
            /**
             * URL： jdbc:mysql://127.0.0.1:3300/test  **这里的地址和 LOCALHOST_HOST 一致
             */
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testDB", "root", "Concordia2020");
        } catch (SQLException e) {
            //log.error("get connection failure", e);
            System.out.print("get connection failure"+e.getErrorCode());
        }
        return conn;
    }

    public static Connection openSSH() throws Exception{

        String localhost = "127.0.0.1";
        String db = "testDB";
        String db_user = "root";
        String db_pass = "Concordia2020";
        String ssh_host = "192.99.246.175";
        String ssh_user = "root";
        String ssh_password = "O2q3C4al";

        JSch jsch = new JSch();
        Session session = jsch.getSession(ssh_user, ssh_host, 22);
        session.setPassword(ssh_password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        System.out.println(session.getServerVersion());

        int assinged_port = session.setPortForwardingL(localhost,3366, ssh_host, 3306);

        System.out.println("localhost:" + assinged_port);

        //return assinged_port;
        Connection conn = null;
        String url = "jdbc:mysql://127.0.0.1:3306/testDB?user=root&password=Concordia2020";
        try {
            Class.forName(
                    "com.mysql.jdbc.Driver");
            java.sql.Connection connection =
                    java.sql.DriverManager.getConnection(url);

            java.sql.DatabaseMetaData metadata = connection.getMetaData();

            System.out.println("successfully connected!");
        } catch (SQLException e) {
            //log.error("get connection failure", e);
            System.out.print("get connection failure"+e.getErrorCode());
        }
        return conn;
    }

    public String getPropValues() throws IOException {

        try {
            Properties prop = new Properties();
            String propFileName = "config.properties";

            inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            Date time = new Date(System.currentTimeMillis());

            // get the property value and print it out
            String user = prop.getProperty("host_ip");
            String company1 = prop.getProperty("host_name");
            String company2 = prop.getProperty("host_password");
            String company3 = prop.getProperty("ip");

            result = "Company List = " + company1 + ", " + company2 + ", " + company3;
            System.out.println(result + "\nProgram Ran on " + time + " by user=" + user);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        } finally {
            //inputStream.close();
        }
        return result;
    }

    public static void closeSSH(){
        session.disconnect();
    }

    public static void main(String args[]) throws Exception {
        Message test = new Message(new User(""), "halo");
        test.getPropValues();
    }
}
