package PS.Graph;

import java.io.*;
import java.util.*;

public class boj_18405_경쟁적전염 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int n ;
    private static int k ;
    private static int[][] map;
    private static boolean[][] used;
    private static PriorityQueue<int[]>pq;
    private static int[] dx= {0,0,-1,1};
    private static int[] dy= {-1,1,0,0};


    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        used =new boolean[n][n];
        pq = new PriorityQueue<>((o1,o2)->{
            if(o1[2]==o2[2])
                return o1[3]-o2[3];
            return o1[2]-o2[2];
        });

        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>0) {
                    used[i][j] = true;
                    pq.add(new int[]{i,j,1,map[i][j]});
                }
            }
        }
        st =new StringTokenizer(br.readLine());
        int level = Integer.parseInt(st.nextToken());
        int oy = Integer.parseInt(st.nextToken());
        int ox = Integer.parseInt(st.nextToken());
        bfs(oy,ox,level);
        close();
    }

    public static void bfs(int oy,int ox , int second){
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            // System.out.println(Arrays.toString(curr));
            int y = curr[0];
            int x = curr[1];
            int sec = curr[2];
            int level = curr[3];

            if(sec > second){
                // System.out.println(map[oy-1][ox-1]);
                break;
            }

            for(int i = 0; i<4 ;i++ ){
                int ny = y+dy[i];
                int nx = x+dx[i];

                if(ny<0 || nx < 0 || ny >= n || nx >= n|| used[ny][nx] ) continue;

                used[ny][nx]= true;
                map[ny][nx] = level;
                pq.add(new int[]{ny,nx,sec+1, level});
            }
        }
        // print(map);
        System.out.println(map[oy-1][ox-1]);
    }
    private static void print(int[][]map){
        System.out.println("------");
        for(int i = 0 ; i < n ; i++){
            System.out.println(Arrays.toString(map[i]));
        }
    }
    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}

/*
** 간략한 풀이 :
*/
