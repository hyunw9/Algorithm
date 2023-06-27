package prgmrs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Openchat {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

    }
    public String[] solution(String[] record) {
        HashMap <String,String> comment = new HashMap<>(2);
        comment.put("Enter","님이 들어왔습니다.");
        comment.put("Leave","님이 나갔습니다.");

        HashMap <String, String>map = new HashMap<>(record.length);
        ArrayList<String> answer =new ArrayList<>();
        for (String s : record) {
            String []split = s.split(" ");
            if(split.length == 3) {
                map.put(split[1], split[2]);
            }
        }
        for (String s : record) {
            String []split = s.split(" ");
            if(comment.containsKey(split[0])){
                answer.add(map.get(split[1]) + comment.get(split[0]));
            }
            
        }
        return answer.toArray(new String[0]);

        }
    }


