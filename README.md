## Executing Curl: <h3>

* <h4>Post Messages:
  - curl -d "user_name=johnson&message=testMessage4" http://localhost:8080/MessageServlet
* <h4>Get Messages:
  - curl -X GET "http://localhost:8080/MessageServlet
  - curl -X GET "http://localhost:8080/MessageServlet?from=04:30:40&to=04:31:10"