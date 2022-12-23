package com.ddoooe.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ddoooe.toy_servlets.dao.PollDetailDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class PollDetailServelts extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollDetailDB pollWithDB = new PollDetailDB();
        // function 불러오기, 밖에서 선언
        HashMap<String, Object> question = null;
        ArrayList<HashMap> answer_list = null;
        // HashMap<String, Object> answer = null;
        try {
            // function 재선언
            question = pollWithDB.getQuestion(questions_Uid);
            answer_list = pollWithDB.getAnswer(questions_Uid);
            // question 터미널 출력 확인용
            System.out.println(question.get("ORDERS") + ". " + question.get("QUESTIONS"));
            // for(int i = 0; i < answer_list.size(); i++){
            //     answer = answer_list.get(i);
            //     // answer 터미널 출력 확인용
            //     System.out.println("("+answer.get("ORDERS")+") " + answer.get("EXAMPLE") );
            // }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // output with html
        // jsp 입장에서 데이터 받는, 서블릿에서 데이터 넘겨주는
        request.setAttribute("question", question);
        request.setAttribute("answer_list", answer_list);

        // jsp로 작동하도록 방향 트는 url 인스턴스화(=printWriter 대체용)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        // forward하면서 request, response 모두 넘겨주는
        requestDispatcher.forward(request, response);
    }
}
