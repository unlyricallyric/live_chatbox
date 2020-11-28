package com.message.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.message.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class BlogUtil {

    public static void printMessage(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h3>" + message + "</h3>");
    }

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

    public static String getJson(List<Object> o) throws IOException {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;

    }

    public static void main(String args[]) throws NoSuchAlgorithmException, IOException {

        User tester = new User(1,"user1", "password1", "firstname1", "lastname1", "tom@gmail.com", "0");
        User tester1 = new User(2,"user2", "password2", "firstname2", "lastname2", "tom@gmail.com", "0");
        User tester2 = new User(3,"user3", "password3", "firstname3", "lastname3", "tom@gmail.com", "0");

        List<Object> l = new ArrayList<>();
        l.add(tester);
        l.add(tester1);
        l.add(tester2);

        System.out.println(getJson(l));

    }
}
