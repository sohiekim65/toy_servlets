package com.ddoooe.toy_servlets.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class PollDetailDB {
    public HashMap<String, Object> getQuestion(String questionsUid) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM QUESTIONS_LIST " +
                        " WHERE QUESTIONS_UID = '"+questionsUid+"'";
        
        ResultSet resultSet = statement.executeQuery(query);

        // 로우 하나를 받아내는 데이터를 결정해야 한다.
        // 넘겨줄 수 있는 건 3가지 중 하나다(지금은 row하나라 hashMap)
        HashMap<String, Object> result = null;
        while(resultSet.next()){
            result = new HashMap<>();
            result.put("QUESTIONS_UID", resultSet.getString("QUESTIONS_UID"));
            result.put("QUESTIONS",resultSet.getString("QUESTIONS"));
            result.put("ORDERS",resultSet.getInt("ORDERS"));
        }
        return result;
    }

    public ArrayList<HashMap> getAnswer(String questionsUid) throws SQLException{
        Commons commons = new Commons();
        Statement statement = commons.getStatement();

        String query = "SELECT * FROM ANSWERS INNER JOIN EXAMPLE_LIST " +
                        " ON ANSWERS.EXAMPLE_UID = EXAMPLE_LIST.EXAMPLE_UID " +
                       " WHERE QUESTIONS_UID = '"+questionsUid+"'";
        
        ResultSet resultSet = statement.executeQuery(query);

        // 넘겨줄 수 있는 건 3가지 중 하나(bean, hashMap, arrayList)
        // 출력할 때 ArrayList 필요. 마지막으로 묶어주기
        ArrayList<HashMap> answer_list = new ArrayList<>();
        HashMap<String, Object> answer = null;
        while(resultSet.next()){
            answer = new HashMap<>();
            answer.put("EXAMPLE_UID", resultSet.getString("EXAMPLE_UID"));
            answer.put("EXAMPLE",resultSet.getString("EXAMPLE"));
            answer.put("ORDERS",resultSet.getInt("ORDERS"));

            answer_list.add(answer);
        }
        return answer_list;
    }
}
