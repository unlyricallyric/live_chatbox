package com.message.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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

    public static void main(String args[]) throws NoSuchAlgorithmException {
        String password = "helloworld";
        System.out.println(passEncoding(password));
    }
}
