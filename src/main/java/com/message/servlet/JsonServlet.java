package com.message.servlet;

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
        PrintWriter out = response.getWriter();
        String js2 = "{'name':'user1', 'message':'message1'}";

        Map<String, String> options = new LinkedHashMap<>();
        options.put("value1", "label1");
        options.put("value2", "label2");
        options.put("value3", "label3");

       // JSONObject json = new JSONObject(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("post return");


    }
}
