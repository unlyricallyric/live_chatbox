package com.message;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

    public static void main(String[] args) throws IOException {
        Properties prop = new Properties();
        String propFile = "/config.properties";

        InputStream inputStream = CTestDriver.class.getClassLoader().getResourceAsStream(propFile);
        prop.load(inputStream);

        System.exit(1);
        try
        {
            String strSshUser = "root";                  // SSH loging username
            String strSshPassword = "O2q3C4al";                   // SSH login password
            String strSshHost = "192.99.246.175";          // hostname or ip or SSH server
            int nSshPort = 22;                                    // remote SSH host port number
            String strRemoteHost = "localhost";  // hostname or ip of your database server
            int nLocalPort = 3366;                                // local port number use to bind SSH tunnel
            int nRemotePort = 3306;                               // remote port number of your database
            String strDbUser = "root";                    // database loging username
            String strDbPassword = "Concordia2020";                    // database login password

            CTestDriver.doSshTunnel(strSshUser, strSshPassword, strSshHost, nSshPort, strRemoteHost, nLocalPort, nRemotePort);

            Class.forName(
                    "com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:"+nLocalPort+"/testDB", strDbUser, strDbPassword);

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Persons");

            while (rs.next()) {
                String lastName = rs.getString("LastName");
                System.out.println(lastName + "\n");
            }

            con.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
        finally
        {
            System.exit(0);
        }
    }
}