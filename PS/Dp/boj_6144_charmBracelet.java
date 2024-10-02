package PS.Dp;

import java.io.*;
import java.util.*;

public class boj_6144_charmBracelet {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        
        int[] ans = new int[m+1];
        
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            int w= Integer.parseInt(st.nextToken());
            int d= Integer.parseInt(st.nextToken());

            for(int j = m; j >=1; j--){
                if(j - w >=0){
                    ans[j] = Math.max(ans[j], ans[j-w]+d);
                }
            }
            System.out.println(Arrays.toString(ans));
        }

        System.out.println(ans[m]);
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