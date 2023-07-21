package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15650_N과M2 {
    static int N;
    static int M;
    static boolean []used;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        used = new boolean[N+1];
        backtrack(0,0,"");
        System.out.println(sb);
    }
    public static void backtrack(int num, int cnt, String s ){
        if(cnt == M){
            sb.append(s.trim()+ "\n");

            return;
        }
        for (int i = num + 1; i < N+1; i++) {
            if(!used[i]){
                used[i] = true;
                backtrack(i,cnt+1,s+" "+ i);
                used[i]=false;
            }
        }
        }
    }

