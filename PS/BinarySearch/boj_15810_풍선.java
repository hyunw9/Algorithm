package PS.BinarySearch;

import java.io.*;
import java.util.*;
public class boj_15810_풍선 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] bal = new int[n];
        st = new StringTokenizer(br.readLine());
        long high = 0;
        long min = 1;

        for(int i = 0; i < n ; i++){
            bal[i] = Integer.parseInt(st.nextToken());
            high = Math.max(high,bal[i]);
        }
        long max = high *m;
        long answer=high;
    //    System.out.println("min : "+ min + " max : "+ max);
        while(min <=max){

            long mid = (min + max) / 2; // 중간 시간 
            long cnt = 0 ; 
            for(int i = 0 ; i < n ; i++){
                cnt+= (mid/bal[i]);
            }
        
            // System.out.println("mid : "+ mid + " cnt : " + cnt);
            if(cnt >= m ){ //목표치 보다 크다면 줄여야 함 
                answer = mid;
                max = mid -1;
            }else{ //작다면 높여야 함
                min = mid +1;
            }
        }
        System.out.println(answer);
        close();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
