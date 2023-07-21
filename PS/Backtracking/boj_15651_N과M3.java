package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15651_N과M3 {
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        backtracking(0,"");
        System.out.println(sb);

    }
    public static void backtracking(int cur , String s){
        if(cur == M ){
            sb.append(s.trim()+"\n");
            return;
        }
        for (int i = 1; i < N+1; i++) {
            backtracking(cur+1,s+ " "+i);
        }

    }
}
