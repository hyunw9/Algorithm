package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_6603_로또 {
    static boolean[]visited;
    static int[] arr;
    static int K=1;
    static int[] S;
    static StringBuilder sb =new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            S = new int[K];
            for (int i = 0; i < S.length; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[K + 1];
            backtrack(0, 0, "");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void backtrack(int num,int cnt, String s){
        if(cnt==6){
            sb.append(s.trim()+"\n");
            return;
        }
        for (int i = num; i < K; i++) {
                if(!visited[i]){
                    visited[i]=true;
                    backtrack(i,cnt+1,s+    " "+ S[i]);
                    visited[i]=false;
                }
            }
        }
    }

