package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합 {
    static int N;
    static int M;
    static boolean []used;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N+1];
        backtracking(0,"");
        System.out.println(sb);
    }
        static void backtracking (int cnt , String s){

        if(cnt == M ){
            sb.append(s.trim()+ "\n");
        }

            for (int i = 0; i < N; i++) {
                if(!used[i]){
                    used[i]=true;
                    backtracking(cnt+1, s+ " " +i);
                    used[i]=false;
                }
            }
    }
}
