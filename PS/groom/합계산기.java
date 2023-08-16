package PS.groom;

import java.io.*;
import java.util.Objects;
import java.util.StringTokenizer;

public class 합계산기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int sum = 0;
        
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            String cc = st.nextToken();
            int right = Integer.parseInt(st.nextToken());

            if(Objects.equals(cc, "+")){
                sum += left + right;
            }
            if(Objects.equals(cc, "-")){
                sum += left - right;
            }
            if(Objects.equals(cc, "/")){
                sum += left / right;
            }
            if(Objects.equals(cc, "*")){
                sum += left * right;
            }

        }
        System.out.println(sum);
    }
}
