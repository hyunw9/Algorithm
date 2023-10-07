package PS.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_4963_섬의개수 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ans;

    private static int w;
    private static int h;

    private static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    private static int[] dy = {-1, 1, 0, 0, -1, -1, 1, 1};

    public static void main(String[] args) throws IOException {
        init();

        while(true) {
            ans = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) break;

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    if (st.nextToken().equals("1")) {
                        map[i][j] = 1;
                    }
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        ans++;
                    }
                }
            }
            bw.write(ans + "\n");
        }
        close();
    }

    public static void dfs(int r, int c) {

        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nx = dx[i] + c;
            int ny = dy[i] + r;

            if (nx < 0 || nx >= w || ny < 0 || ny >= h) continue;

            if (visited[ny][nx]) continue;

            if (map[ny][nx] == 0) continue;

            dfs(ny, nx);
        }
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
