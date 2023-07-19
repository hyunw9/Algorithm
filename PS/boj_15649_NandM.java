package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15649_NandM {
    static int N,M;
    static int []arr ;
    static boolean []is_used ;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        is_used= new boolean[N];
        for (int i = 0; i < M; i++) {
                is_used[i] = false;
        }
        dfs(N,M,0);
        System.out.println("st = " + sb);
    }
    public static void dfs(int N, int M ,int depth){
        if (depth== M ){
            for (int val:arr
                 ) {
                sb.append(val).append(" ");

            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if(!is_used[i]){
                is_used[i]= true;
                arr[depth] = i +1;
                dfs(N,M,depth+1);

                is_used[i]=false;
            }
        }
        return;
    }

}
//

