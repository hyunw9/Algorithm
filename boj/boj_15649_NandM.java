package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15649_NandM {
   static int N,M;
   static int []nums;
   static boolean[]ischecked;
   static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        nums = new int[N+1];
        ischecked = new boolean[N+1];
        for (int i = 0; i < N+1; i++) {
            ischecked[i] = false;
        }
        dfs(0);
        System.out.println("sb = " + sb);
        }

    private static void dfs(int n ) {
        if( n== M ){
            for (int a: nums
                 ) {
                sb.append(a).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <=N ; i++) {
            if(!ischecked[i]){
                ischecked[i]=true;
                nums[n] = i;
                dfs(n+1);
                ischecked[i]=false;
            }

        }
    }
}


