package com.ddoooe.toy_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import com.ddoooe.toy_servlets.DatasInfor;
import com.ddoooe.toy_servlets.beans.PollBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/pollListServlet")
public class PollListServlets extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 출력
        response.setContentType("text/html;charset=UTF-8");
        DatasInfor datasInfor = new DatasInfor();
        // 메소드 묶음 호출
        HashMap<String, Object> pollsData = datasInfor.getPollsData();

        // Display areas
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<meta charset='UTF-8' />");
        printWriter.println("<title>pollListServlets</title>");
        printWriter.println(" <link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("/>");
        printWriter.println("</head>");

        printWriter.println("<body>");
        printWriter.println(" <div class='container pb-2 mt-3'>");
        printWriter.println("<div class='h1 mb-3 fs-1 fw-bold'>Survey Servlets</div>");

        // 개인정보
        HashMap<String, String> personalData = datasInfor.getPersonalData();
        printWriter.println(" <div class='border bg-light rounded p-5 mb-3'>");
        printWriter.println("<div class='h6'> 이름 : " + personalData.get("name") + ", 소속 : " + personalData.get("team") + "</div>");

        // 질문과 답항
        int answerId = 0;
        ArrayList<PollBean> dataListWithPollBean = (ArrayList<PollBean>) pollsData.get("dataPollBean");
        for(int i = 0; i < dataListWithPollBean.size(); i++){
            PollBean pollBean = dataListWithPollBean.get(i);
            printWriter.println("<div class='mb-3'>");
            // 질문
            printWriter.println("<div>" + (i+1) + ". " + pollBean.getQuestion() + "</div>");
            for(int j = 0; j < pollBean.getAnswer().size(); j++){
                // 답항 ArrayList에서 하나씩 가져오기
                printWriter.println("<input");
                printWriter.println("type='radio'");
                printWriter.println("class='form-radio-input'");
                printWriter.println(" name='radio'");
                printWriter.println(" id='"+ answerId +"'");
                printWriter.println("/>");
                printWriter.println("<label class='form-radio-label' for='"+ answerId+"'>");
                printWriter.println(pollBean.getAnswer().get(j) + "</label>");
                answerId++;
            }
            printWriter.println("</div>");
        }
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println(" <button type='submit' class='btn btn-primary w-20'>Sign in</button>");
        printWriter.println("</div>");
        printWriter.println("</div>");
        printWriter.println("</body>");
    }
}
