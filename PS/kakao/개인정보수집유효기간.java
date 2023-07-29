package PS.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 개인정보수집유효기간 {
    public static void main(String[] args) {
        String[] term = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        solution("2020.01.01", term, privacies);
    }

    public static ArrayList<Integer> solution(String today, String[] terms, String[] privacies) {
        StringTokenizer st;
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> termmap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            st = new StringTokenizer(terms[i], " ");
            String type = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (num == 12) {
                termmap.put(type, 10000);
            } else {
                termmap.put(type, num * 100);
            }
        }
        System.out.println(termmap);
        int cur = Integer.parseInt(today.replace(".",""));

        for (int i = 0; i < privacies.length; i++) {
            st=new StringTokenizer(privacies[i]," ");
            int obj = Integer.parseInt(st.nextToken().replace(".",""));
            int typevalue= termmap.get(st.nextToken());
            System.out.println("obj = " + obj);
            System.out.println("typevalue = " + typevalue);
            System.out.println(cur-obj);
            if(cur-obj >=typevalue-1){
                answer.add(i+1);
            }

        }
        System.out.println(answer);

        return answer;
    }
}
