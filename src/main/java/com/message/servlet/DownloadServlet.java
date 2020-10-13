package com.message.servlet;

import com.message.handler.ChatManager;
import com.message.handler.Message;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URLEncoder;
import java.time.LocalTime;
import java.util.TreeMap;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String format = request.getParameter("download");

        String filePath = this.getServletContext().getRealPath("/");
        String downloadFilename = (format.equals("text"))?"chat_history.txt":"chat_history.xml";
        downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");

        //generate file
        File file = new File(filePath + downloadFilename);
        file.createNewFile();

        //write to file
        FileWriter fileWriter = new FileWriter(file);
        TreeMap<LocalTime, Message> msg_db = ChatManager.ListMessages();
        String date, username, message;

        if(format.equals("xml")){
            fileWriter.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n");
        }

        for (LocalTime i : msg_db.keySet()) {
            date = i.toString();
            username = msg_db.get(i).getUsername();
            message = msg_db.get(i).getMessage();
            if(format.equals("text")) {
                fileWriter.append("Time: " + date + " User: " + username + " Message: " + message + "\n");
            }else{
                fileWriter.append("<chat>\n");
                fileWriter.append("<date>"+date+"</date>\n");
                fileWriter.append("<user>"+username+"</user>\n");
                fileWriter.append("<message>"+message+"</message>\n");
                fileWriter.append("</chat>\n");
            }
        }

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
