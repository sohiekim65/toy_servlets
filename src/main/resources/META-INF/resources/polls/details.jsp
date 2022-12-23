<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.HashMap, java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
  </head>
  <body>
  <% 
  HashMap<String, Object> question = (HashMap<String, Object>)request.getAttribute("question"); 
  ArrayList<HashMap> answer_list = (ArrayList<HashMap>)request.getAttribute("answer_list"); 
  %>
    <div class="container mt-3">
    <%-- prev, next 버튼 --%>
      <div class="mb-3">
      <% if((int)question.get("ORDERS") == 1){ %>
          <a href="" class="btn btn-primary" onclick="alert('첫번째 페이지입니다.')"
            >Prev</a
          > 
          <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")+1 %>" class="btn btn-primary"
            >Next</a
          > 
      <% } else if ((int)question.get("ORDERS") == 5){ %>
          <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")-1 %>" class="btn btn-primary"
            >Prev</a
          > 
          <a href="" class="btn btn-primary" onclick="alert('마지막 페이지입니다.')"
            >Next</a
          > 
          <% } else { %>
                  <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")-1 %>" class="btn btn-primary"
            >Prev</a
          > 
                  <a href="/polls/PollServlet?QUESTIONS_UID=Q<%= (int)question.get("ORDERS")+1 %>" class="btn btn-primary"
            >Next</a
          > 
          <% } %>
      </div>
      
      <%-- questions --%>
      <div class="mb-1">
        <%= question.get("ORDERS") %>. <%= question.get("QUESTIONS") %>
      </div>

      <%-- answers --%>
      <div>
        <%
          for(int i = 0; i < answer_list.size(); i++){
        %>
        <div><input type="radio" name="radio_check" id="<%= answer_list.get(i).get("EXAMPLE_UID") %>" value="<%= answer_list.get(i).get("EXAMPLE_UID") %>"/>
        <label for="<%= answer_list.get(i).get("EXAMPLE_UID") %>">
      (<%= answer_list.get(i).get("ORDERS") %>) <%= answer_list.get(i).get("EXAMPLE") %>
        </label>
      </div>
      <% } %>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
