package prgmrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class 숫자짝궁 {
    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";
        System.out.println(solution(X, Y));
    }

    private static String solution(String x, String y) {
        HashMap<Character, Integer> xmap = new HashMap<>();
        HashMap<Character, Integer> ymap = new HashMap<>();
        ArrayList<Integer> arr = new ArrayList<>();
        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < x.length(); i++) {
            char now = x.charAt(i);
            if (xmap.get(now) == null) {
                xmap.put(now, 1);
            } else {
                xmap.put(now, xmap.get(now) + 1);
            }
        }
        for (int i = 0; i < y.length(); i++) {
            char now = y.charAt(i);
            if (ymap.get(now) == null) {
                ymap.put(now, 1);
            } else {
                ymap.put(now, ymap.get(now) + 1);
            }
        }
        if (xmap.size() < ymap.size()) {
            for (Character key : xmap.keySet()) {
                if (ymap.get(key) != null) {
                    int cnt = xmap.get(key);
                    cnt = Math.min(cnt, ymap.get(key));
                    for (int i = 0; i < cnt; i++) {
                        arr.add(Character.getNumericValue(key));
                    }
                }
            }
        }
        Collections.sort(arr,((o1, o2) -> {return o2-o1;}));

        if(arr.size()==0){
            return sb.append("-1").toString();
        }
        else{
            for (int i = 0; i < arr.size(); i++) {
                if(i >0&& arr.get(i-1) == 0 && arr.get(i)== 0) continue;
                sb.append(arr.get(i));
            }
        }
        return sb.toString();
    }
}
