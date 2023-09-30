package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2178_미로탐색 {
    public static class Point{

        private int y;
        private int x;

        public Point(final int y, final int x) {
            this.y = y;
            this.x = x;
        }
    }
    static BufferedReader br;
    static BufferedWriter bw;

    static int []dx = {0,0,-1,1};
    static int []dy = {-1,1,0,0};

    static int N;
    static int M;

    static int [][]map;
    static boolean [][]visited;
    static ArrayDeque<Point> dq;
    static int count;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dq = new ArrayDeque<>();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char nowChar = line.charAt(j);
                if(nowChar == '1'){
                    map[i][j] = 1;
                    if(i == 0&& j==0){
                        visited[i][j] = true;
                        dq.addLast(new Point(i,j));
                    }
                }else map[i][j] = -1;
            }
        }
        bfs();
        count = map[N-1][M-1];
        bw.write(count + "");
        close();
    }

    public static void bfs() {
        while(!dq.isEmpty()){
            Point now = dq.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;

                if(ny < 0 || nx < 0 || nx >= M || ny >= N){
                    continue;
                }

                if(visited[ny][nx]||map[ny][nx] == -1){
                    continue;
                }
                map[ny][nx] = map[now.y][now.x] +1;
                visited[ny][nx] = true;
                dq.addLast(new Point(ny,nx));
            }
        }
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
