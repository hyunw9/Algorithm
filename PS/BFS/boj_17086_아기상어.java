package PS.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_17086_아기상어 {
    static int M;
    static int N;
    static int result;
    static int [][] map ;
    static ArrayDeque<Node> dq = new ArrayDeque<>();


    static int[] dx= {0,0,-1,1,-1,1,-1,1};
    static int[] dy= {-1,1,0,0,-1,-1,1,1};
    public static class Node{
        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }

        int row;
        int column;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int key = Integer.parseInt(st.nextToken());
                map[i][j] = Integer.MAX_VALUE;
                if (key == 1){
                    map[i][j] = 0;
                    dq.addLast(new Node(i,j));
                }
            }
        }
        bfs();

        System.out.println(result);
    }
    public static void bfs(){
        while(!dq.isEmpty()){
            Node now = dq.pollFirst();

            for (int i = 0; i < dx.length; i++) {
                int nx = now.column +  dx[i];
                int ny = now.row + dy[i];
                if (nx >= N || nx < 0 || ny >= M || ny < 0){
                    continue;
                }
                if(map[ny][nx]>map[now.row][now.column] + 1){
                    map[ny][nx] = map[now.row][now.column] +1;
                    dq.addLast(new Node(ny,nx));
                    result = Math.max(result,map[ny][nx]);
                }
            }
        }
    }
}
