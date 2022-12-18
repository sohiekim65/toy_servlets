package com.ddoooe.toy_servlets;

import java.util.ArrayList;
import java.util.HashMap;

import com.ddoooe.toy_servlets.beans.PollBean;

public class DatasInfor {
    // 개인정보
    public HashMap<String, String> getPersonalData(){
        HashMap<String, String> personal = new HashMap<String, String>();
        personal.put("name", "김소희");
        personal.put("team", "KH");
        return personal;
    }

    // 메소드 묶음
    public HashMap<String, Object> getPollsData(){
        DatasInfor datasInfor = new DatasInfor();
        HashMap<String, Object> pollsData = new HashMap<>();

        // 개인정보
        pollsData.put("dataPersonalBean", datasInfor.getPersonalData());

        // 질문과 답항
        pollsData.put("dataPollBean", datasInfor.getDataPollBean());

        return pollsData;
    }

    // 질문과 답항
    public ArrayList<PollBean> getDataPollBean(){
        ArrayList<PollBean> pollBeanList = new ArrayList<>();
        PollBean pollBean = new PollBean();
        pollBean.setQuestion("해당 매장을 방문시 매장은 청결 하였습니까?");
        pollBean.setAnswer("전혀 아니다");
        pollBean.setAnswer("아니다");
        pollBeanList.add(pollBean);

        PollBean pollBean02 = new PollBean();
        pollBean02.setQuestion("주문시 직원은 고객님께 친절 하였습니까?");
        pollBean02.setAnswer("전혀 아니다");
        pollBean02.setAnswer("아니다");
        pollBean02.setAnswer("보통이다");
        pollBeanList.add(pollBean02);

        PollBean pollBean03 = new PollBean();
        pollBean03.setQuestion("주문하신 음료가 나오기까지 시간이 적당하였습니까?");
        pollBean03.setAnswer("전혀 아니다");
        pollBean03.setAnswer("아니다");
        pollBeanList.add(pollBean03);

        PollBean pollBean04 = new PollBean();
        pollBean04.setQuestion("해당 매장을 다음에도 재방문 하실 의향이 있으십니까?");
        pollBean04.setAnswer("전혀 아니다");
        pollBean04.setAnswer("아니다");
        pollBean04.setAnswer("보통이다");
        pollBean04.setAnswer("그렇다");
        pollBean04.setAnswer("매우 그렇다");
        pollBeanList.add(pollBean04);

        PollBean pollBean05 = new PollBean();
        pollBean05.setQuestion("직원이 제조한 음료에 대해 맛은 좋았습니까?");
        pollBean05.setAnswer("전혀 아니다");
        pollBean05.setAnswer("아니다");
        pollBean05.setAnswer("보통이다");
        pollBeanList.add(pollBean05);

        return pollBeanList;
    }
}
