package boj;

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
    static ArrayList<Integer> array = new ArrayList<>();
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
        dfs(0);
    }
        public static void dfs(int wall){
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
//        ArrayDeque<int[]>


        }
}