package com.message.servlet;

import com.message.controller.PostController;
import com.message.handler.ChatManager;
import com.message.handler.Message;
import com.message.model.Post;
import com.message.model.User;
import com.message.controller.UserController;
import com.message.utils.BlogUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalTime;
import java.util.TreeMap;

@WebServlet("/PosterServlet/*")
public class PosterServlet extends HttpServlet {
    private static final int ARBITARY_SIZE = 1048;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getPathInfo();

        switch (action) {
            case "/createPost":
                createPost(request, response);
                break;
            case "/getAllPost":
                getAllPost(request, response);
                break;
            case "/update":
                updatePost(request, response);
                break;
            case "/download":
                downloadPost(request, response);
                break;
        }
    }

    private void createPost(HttpServletRequest request, HttpServletResponse response){

        String posted_by = request.getParameter("posted_by");
        String post_title = request.getParameter("post_title");
        String post_message = request.getParameter("post_message");
        String post_group = request.getParameter("post_group");

        Post post = new Post(posted_by, post_title, post_message, post_group);

        try{
            PostController pc = new PostController();
            pc.createPost(post);
            String url = "/index_blog.jsp";
            response.sendRedirect(url);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private void getAllPost(HttpServletRequest request, HttpServletResponse response) {

        HttpSession session = request.getSession();
        String user_group = (String) session.getAttribute("user_group");

        try{
            PostController pc = new PostController();
            String result = pc.getAllPost(user_group);
            response.getWriter().write(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void updatePost(HttpServletRequest request, HttpServletResponse response){

        String delete = request.getParameter("delete");
        String update = request.getParameter("update");

        String command = (delete!=null)?delete:update;

        String post_id = request.getParameter("post_id");
        String post_title = request.getParameter("post_title");
        String post_message = request.getParameter("post_message");

        try{
            PostController pc = new PostController();

            switch(command){
                case "delete":
                    pc.deletePost(response, post_id);
                    break;
                case "update":
                    pc.updatePost(response, post_id, post_title, post_message);
                    break;
                case "download":
                    System.out.println("this is download");
                    downloadPost(request, response);
                    break;
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void downloadPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        String id = (String)session.getAttribute("download_id");
        String title = (String)session.getAttribute("download_title");
        String message = (String)session.getAttribute("download_message");
        String author = (String)session.getAttribute("download_author");
        String date = (String)session.getAttribute("download_date");

        System.out.println("message: " + message);

        String filePath = this.getServletContext().getRealPath("/");
        String downloadFilename = "post_" + id + ".xml";
        downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");

        //generate file
        File file = new File(filePath + downloadFilename);
        file.createNewFile();

        //write to file
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");

        fileWriter.append("<post>\n");
        fileWriter.append("<id>"+id+"</id>\n");
        fileWriter.append("<date>"+date+"</date>\n");
        fileWriter.append("<title>"+title+"</title>\n");
        fileWriter.append("<author>"+author+"</author>\n");
        fileWriter.append("<message>"+message+"</message>\n");
        fileWriter.append("</post>\n");

        fileWriter.close();

        if(file.exists()){
            response.setContentLength((int) file.length());
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);
            response.setContentType("application/octet-stream");
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] b = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(b);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(b);
            bufferedInputStream.close();
            outputStream.flush();
            outputStream.close();
        }

    }
}
