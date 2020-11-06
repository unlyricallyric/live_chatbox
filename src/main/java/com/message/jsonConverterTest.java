package com.message;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.message.model.User;

import java.io.File;
import java.io.IOException;

/**
 * Create by brent on 11 2020-11-04, 2020
 */
public class jsonConverterTest {


    public static void main(String[] args) throws IOException {

        User tester = new User("Tom", "Tom", "Tom", "Tom", "tom@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(new File("target/tester.json"), tester);


    }


}
