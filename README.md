## Executing Curl: <h3>

* <h4>Get All Message:
  - curl http://localhost:8080/MessageOp

* <h4>Get date-range Message:
  - curl -X GET "http://localhost:8080/MessageOp?from=19:45:55&to=19:46:17"
  
* <h4>Post Messages:
  - curl -d "user_name=Johnson&message=TestMessage" http://localhost:8080/MessageOp
  
* <h4>Delete All Messages:
  - curl -X DELETE http://localhost:8080/MessageOp
  - curl -X DELETE "http://localhost:8080/MessageOp?from=19:47:53&to=19:47:56"