package PS.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 문자열나누기 {
    static String s;
    static HashMap<String, Integer> map = new HashMap<>();
    static int score;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine(); //N을 사용하지 않으므로 읽고 무시
        s = br.readLine(); // 문자열 read
        divideString(s);
        System.out.println(score);
    }

    public static void divideString(String str) {
        int length = str.length();

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String firstPart = str.substring(0, i);
                String secondPart = str.substring(i, j);
                String thirdPart = str.substring(j, length);
                map.put(firstPart, 0);
                map.put(secondPart, 0);
                map.put(thirdPart, 0);
            }
        }
        list = new ArrayList<>(map.keySet());
        list.sort(Comparator.naturalOrder());

        for (int i = 1; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                String firstPart = str.substring(0, i);
                String secondPart = str.substring(i, j);
                String thirdPart = str.substring(j, length);
                setScore(firstPart,secondPart,thirdPart);
            }
        }
    }

    public static void setScore(String first, String second, String third) {
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            String now = list.get(i);
            System.out.println("now = " + now);
            if (now.equals(first)) {
                temp += i + 1;
            }
            if (now.equals(second)) {
                temp += i + 1;
            }
            if (now.equals(third)) {
                temp += i + 1;
            }
        }
        score = Math.max(score, temp);
    }
}
