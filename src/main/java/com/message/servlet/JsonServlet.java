package com.message.servlet;

import com.google.gson.Gson;
import com.message.model.Post;
import com.message.model.User;
import com.message.utils.BlogUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

//import org.json.simple.JSONObject ;
//import org.json.simple.JSONArray;
//import org.json.simple.JSONObject;
//import org.json.JSONObject;

@WebServlet("/JsonServlet")

public class JsonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

   // private Gson gson = new Gson();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //cannot think of any scenario for getting user, leave for the moment
        //User u1= new User("the first user");
        //Message m1 = new Message(u1, "the first post content");
        //String userJsonString = this.gson.toJson(m1);
        //JSONObject m2 = new JSONObject();
        //m2.put("date",m2);
        //use the json data
        //JSONArray js1 = new JSONArray();
        //Map m = new LinkedHashMap(4);
        //m.put("name", "user1");
        //m.put("message", "msg1");
        //m.put("date", "date1");
        //js1.add(m);
        PrintWriter out = response.getWriter();
        String js2 = "{'name':'user1', 'message':'message1'}";

        Map<String, String> options = new LinkedHashMap<>();
        options.put("value1", "label1");
        options.put("value2", "label2");
        options.put("value3", "label3");
        Gson gson = new Gson();

       // JSONObject json = new JSONObject(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //out.print("userJsonString");
        //out.write(json.toString());
        LocalDateTime date = LocalDateTime.now();
     //  String json = "{\"Name-1\":\"Matt\", \"Message-1\":\"Json comes\",\"Date-1\":\"2020-11-05\",";
     //   json += "\"Name-2\":\"Louis\", \"Message-2\":\"Json2 comes\",\"Date-2\":\"2020-11-04\",";
     //  json += "\"Name-3\":\"Adam\", \"Message-3\":\"Json3 comes\",\"Date-3\":\"2020-11-02\"}";
        //json += "{\"Name-4\":\"Mortimer\", \"Message-4\":\"Json4 comes\",\"Date-4\":\"2020-11-01\"}";


      //  User tester = new User(1,"user1", "password1", "firstname1", "lastname1", "tom@gmail.com");
      //  User tester1 = new User(2,"user2", "password2", "firstname2", "lastname2", "tom@gmail.com");
      //  User tester2 = new User(3,"user3", "password3", "firstname3", "lastname3", "tom@gmail.com");
        // Post(String posted_by, String post_title, String post_date, String last_modified, String message)
        Post p1 = new Post(1,"Matthew","display","2020-11-07","2020-11-06","what's result");
        Post p2 = new Post(2,"Matthew-2","display-2","2020-11-07-2","2020-11-06-2","what's result-2");
        Post p3 = new Post(3,"Matthew-3","display-3","2020-11-07-3","2020-11-06-3","what's result-3");
        Post p4 = new Post(4,"Matthew-4","display-4","2020-11-07-4","2020-11-06-4","what's result-4");

        List<Object> object_list = new ArrayList<>();
        object_list.add(p1);
        object_list.add(p2);
        object_list.add(p3);
        object_list.add(p4);
        out.write(BlogUtil.getJson(object_list));
       // String json = gson.toJson(object_list);
        //out.write(json);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("post return");


    }
}
