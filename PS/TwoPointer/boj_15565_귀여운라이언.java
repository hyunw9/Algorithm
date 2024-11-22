package PS.TwoPointer;

import java.io.*;
import java.util.*;

public class boj_15565_귀여운라이언 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0 ;
        int r = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;
        while(r<n){
            // System.out.println(l+ " " + r+ " "+ cnt);
            
            if(arr[r] == 1) cnt+=1;

            while(cnt>=k){
                min = Math.min(min,r-l+1);
                if(arr[l]==1) cnt-=1;
                l+=1;
            }
            r+=1;
            
        }
        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
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

/*
** 간략한 풀이 :
*/