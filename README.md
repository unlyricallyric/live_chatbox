## Executing Curl: <h3>

* <h4>Get All Message:
  - curl http://localhost:8080/MessageOp

* <h4>Get date-range Message:
  - curl -X GET "http://localhost:8080/MessageOp?from=19:45:55&to=19:46:17"
  
* <h4>Post Messages:
  - curl -d "user_name=Johnson&message=TestMessage" http://localhost:8080/MessageOp
  
* <h4>Download Files:
  - curl "http://localhost:8080/DownloadServlet?download=text" --output chatHistory.txt
  - curl "http://localhost:8080/DownloadServlet?download=xml" --output chatHistory.xml
  
* <h4>Delete All Messages:
  - curl -X DELETE http://localhost:8080/MessageOp
  - curl -X DELETE "http://localhost:8080/MessageOp?from=19:47:53&to=19:47:56"

----------------------------------------------------------------------------------------------

* <h4>Description:
  - implementation of a simplied Message Board System. A message board is an online discussion 
  site where people can hold conversations in the form of posted messages. The messages are normally 
  longer than chat messages and may have attachments.

* <h4>Release Note:
  - download and import project from GitHub to the IDE
  - set tomcat server to the run configurations
  - put jsch-0.1.55.jar file to the src folder
  - put mysql-connector-java-8.0.22.jar to the tomcat lab folder
  - compile the application