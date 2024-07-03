package PS.Dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1904_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int []arr = new int[N+1];
        if(N<4){
            for (int i = 0; i < N+1; i++) {
                arr[i] = i;
            }
        }else {

            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;

            for (int i =4; i <N+1 ; i++) {
                arr[i] = (arr[i-1] + arr[i-2])% 15746;
            }
        }


        sb.append(arr[N]);
        System.out.println(sb);
    }
}
