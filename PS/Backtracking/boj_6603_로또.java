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
        //0이 나올 때 까지 입력 받기
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
        //목표 개수 (6) 에 도달 시 빈칸 없애고 개행문자 붙여 리턴
        if(cnt==6){
            sb.append(s.trim()+"\n");
            return;
        }

        for (int i = num; i < K; i++) {
                //방문여부 확인
                if(!visited[i]){
                    visited[i]=true;
                    //0~ K 까지 탐색, cnt+1 하며 인덱스 증가, S[i] 번째 값을 문자열에 추가하며 백트래킹
                    backtrack(i,cnt+1,s+    " "+ S[i]);
                    //사용한 방문 배열은 다시 원상복구
                    visited[i]=false;
                }
            }
        }
    }

