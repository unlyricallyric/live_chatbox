package com.message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class CTestDriver
{
    private static void doSshTunnel( String strSshUser, String strSshPassword, String strSshHost, int nSshPort, String strRemoteHost, int nLocalPort, int nRemotePort ) throws JSchException
    {
        final JSch jsch = new JSch();
        Session session = jsch.getSession( strSshUser, strSshHost, 22 );
        session.setPassword( strSshPassword );

        final Properties config = new Properties();
        config.put( "StrictHostKeyChecking", "no" );
        session.setConfig( config );

        session.connect();
        session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
    }

    private static Connection getConnection() throws IOException, JSchException, ClassNotFoundException, SQLException {
        Properties prop = new Properties();
        String propFileName = "config.properties";

        InputStream inputStream = CTestDriver.class.getClassLoader().getResourceAsStream(propFileName);

        if (inputStream != null) {
            prop.load(inputStream);
        } else {
            throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
        }

        Date time = new Date(System.currentTimeMillis());

        // get the property value and print it out
        String host_ip = prop.getProperty("host_ip");
        String host_user = prop.getProperty("host_user");
        String host_pass = prop.getProperty("host_pass");
        int remote_port = Integer.parseInt(prop.getProperty("remote_port"));
        int bind_port = Integer.parseInt(prop.getProperty("bind_port"));
        String db_host = prop.getProperty("db_host");
        int db_port = Integer.parseInt(prop.getProperty("db_port"));
        String db = prop.getProperty("db");
        String db_user = prop.getProperty("db_user");
        String db_pass = prop.getProperty("db_pass");

        CTestDriver.doSshTunnel(host_user, host_pass, host_ip, remote_port, db_host, bind_port, db_port);

        Class.forName(
                "com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:"+bind_port+"/"+db, db_user, db_pass);

        return con;
    }

    public static void main(String[] args) throws IOException, JSchException, SQLException, ClassNotFoundException {

        Connection con = getConnection();

        try {

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