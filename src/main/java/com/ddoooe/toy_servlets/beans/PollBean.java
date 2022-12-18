package com.ddoooe.toy_servlets.beans;

import java.util.ArrayList;

public class PollBean {
    String question;
    ArrayList<String> answer = new ArrayList<>();

    // getter
    public String getQuestion(){
        return this.question;
    }
    public ArrayList<String> getAnswer(){
        return this.answer;
    }

    // setter
    public void setQuestion(String question){
        this.question = question;
    }
    public void setAnswer(String answer){
        // 답항 넣어주기
        this.answer.add(answer);
    }
}
