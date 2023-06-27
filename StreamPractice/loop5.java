package StreamPractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class loop5 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int check =4 ;
        int max= 0;
        max = num/check;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            sb.append("long ");
        }
        sb.append("int");
        System.out.println(sb);
    }
}
