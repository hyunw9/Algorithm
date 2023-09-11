package PS.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_11724_연결요소의개수 {
    static boolean []used ;
    static int answer;
    static ArrayList<Integer>[]arr ;
    static ArrayDeque<Integer> dq ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        used = new boolean[N+1];
        dq = new ArrayDeque<>();
        arr = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
            arr[end].add(start);

        }
        for (int i = 1; i <= N; i++) {
            if(!used[i]){

                bfs(i);
                answer++;

            }
        }
        System.out.println(answer);

    }
    private static void bfs(int start){
        dq.addLast(start);
        used[start] = true;

        while(!dq.isEmpty()){
            int now = dq.pollFirst();
            for (int i = 0; i < arr[now].size(); i++) {
                if(used[arr[now].get(i)]) continue;
                used[arr[now].get(i)] = true;
                dq.addLast(arr[now].get(i));
                }
            }


    }

}
