package PS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_14502_연구소 {
    static int N;
    static int M;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int [][]map;
    static boolean [][]visited;
    static ArrayDeque<Loc> deque = new ArrayDeque<>();
    static int safety = 0;

    public static class Loc {
        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }
        int x;
        int y;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        int [][]dupmap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //dfs 실행, 벽은 아직 0이므로 0 전달
        dfs(0);
        System.out.println(safety);
    }
        public static void dfs(int wall){
        //base case , wall이 3일시 bfs실행 후 리턴
        if(wall == 3 ){
            bfs();
            return;
        }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[i][j] == 0){
                        map[i][j] = 1;
                        dfs(wall+1);
                        map[i][j] = 0;

                    }
                }
            }
        }

         public static void bfs(){
            int [][]virus_map = new int [N][M];
            visited=new boolean[N][M];
            ArrayDeque<Loc> q = new ArrayDeque<>();
            //배열 복사
             for (int i = 0; i < N; i++) {
                 for (int j = 0; j < M; j++) {
                     virus_map[i][j] = map[i][j];
                 }
             }
             //만약 현재 위치가 2면 해당 위치 큐에 넣기
             for (int i = 0; i < N; i++) {
                 for (int j = 0; j < M; j++) {
                     if(virus_map[i][j] == 2){
                        // visited[i][j]=true;
                         q.addFirst(new Loc(i,j));
                     }
                 }
             }

             //BFS
             while(!q.isEmpty()){
                 Loc poll = q.pollLast();
                 for (int i = 0; i < 4; i++) {
                     int xn = poll.x + dx[i];
                     int yn = poll.y + dy[i];
                     if(xn>=0&&xn<N && yn>=0 &&yn<M &&  virus_map[xn][yn]== 0&& !visited[xn][yn]){
                         virus_map[xn][yn] = 2;
                         visited[xn][yn] = true;
                         q.addFirst(new Loc(xn,yn));
                     }
                 }
             }
             count(virus_map);
        }

        //숫자세기
        public static void count(int[][]virusmap){
            int temp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(virusmap[i][j] == 0){
                        temp+=1;
                    }
                }
                safety=Math.max(safety,temp);
            }
        }
}