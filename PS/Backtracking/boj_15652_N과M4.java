package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_15652_N과M4 {

        static int N;
        static int M;
        static StringBuilder sb = new StringBuilder();
        static boolean[] used ;
        public static void main(String[] args) throws IOException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            used= new boolean[N+1];
            backtracking(0,0,"");
            System.out.println(sb);

        }
        public static void backtracking(int num,int cur , String s) {

            if (cur == M) {
                sb.append(s.trim() + "\n");
                return;
            }
            for (int i = num +1; i < N + 1; i++) {

                    backtracking(i-1, cur + 1, s + " " + i);



            }
        }}


