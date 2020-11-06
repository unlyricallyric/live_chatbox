package com.message.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.message.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public final class BlogUtil {

    public static String passEncoding(String password) {
        String passwordToHash = password;
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static Object getJsonObject(Object o) throws IOException {

        JSONPObject jsonpObject = new JSONPObject("", o);   //convert the pass in object to json object

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("target/tester_1.json"), jsonpObject);

        objectMapper.writeValue(new File("target/tester_2.json"), o);

        return jsonpObject;
    }

    public static void main(String args[]) throws NoSuchAlgorithmException, IOException {
//        String password = "helloworld";
//        System.out.println(passEncoding(password));

        User tester = new User("Tom", "Tom", "Tom", "Tom", "tom@gmail.com");

        System.out.println(getJsonObject(tester));

    }
}
