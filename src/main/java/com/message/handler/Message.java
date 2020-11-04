package com.message.handler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Message {

    private String userName;
    private String message;
    private LocalTime date;

    String result = "";
    InputStream inputStream;

    //private static Session session;

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

    public static void main(String args[]) throws Exception {
        Message test = new Message(new User(""), "halo");
        test.getPropValues();
    }
}
