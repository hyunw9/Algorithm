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
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dupmap[i][j] = map[i][j];
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    if(dupmap[i][j]== 0){
                        dupmap[i][j] =1;
                    }
                    Loc loc = new Loc(i,j);
                    visited[i][j]= true;
                    deque.addFirst(loc);
                    bfs(dupmap);
                    for (int g = 0; g < N; g++) {
                        for (int h = 0; h < M; h++) {
                            dupmap[g][h] = map[g][h];
                        }
                    }
                    visited =new boolean[N][M];
                }
            }
        }
        System.out.println(array);
        System.out.println(Collections.max(array));
            }
         public static void bfs(int [][]dup ){

             while(!deque.isEmpty()){
                 Loc current = deque.poll();
                 for (int i = 0; i < 4; i++) {
                     int nx = current.x + dx[i];
                     int ny = current.y + dy[i];
                     Loc next = new Loc(nx,ny);
                     if(next.x >=0 && next.x<N && next.y>=0 && next.y<M &&(dup[next.x][next.y] == 0 && !visited[next.x][next.y])){
                            safety+=1;
                            visited[next.x][next.y] = true;
                            deque.add(next);
                     }
                 }
             }
             array.add(safety);
             safety=0;
         }
        }



