package prgmrs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.StringTokenizer;

public class lowsort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s =br.readLine();
        String answer = "";

        String[] str = s.split("");
        Arrays.sort(str);
        String[] temp = Arrays.copyOf(str, str.length);
        for (int i = 0; i < str.length; i++) {
            temp[i] = str[str.length-i-1];
        }
        //join을 사용해 한 문장으로 합침
        answer = String.join("", temp);


    }
}
