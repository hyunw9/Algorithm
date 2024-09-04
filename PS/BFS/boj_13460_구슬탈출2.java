package PS.BFS;

import java.io.*;
import java.util.*;

public class boj_13460_구슬탈출2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static char[][] map;
  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    map = new char[n][m];
    int[] red = new int[2];
    int[] blue = new int[2];

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      for (int j = 0; j < m; j++) {
        map[i][j] = line.charAt(j);
        if (map[i][j] == 'R') {
          red[0] = i;
          red[1] = j;
        } else if (map[i][j] == 'B') {
          blue[0] = i;
          blue[1] = j;
        }
      }
    }

    int result = bfs(red, blue);
    System.out.println(result);
    close();
  }

  private static int bfs(int[] red, int[] blue) {
    Queue<int[]> queue = new LinkedList<>();

    queue.add(new int[] {red[0], red[1], blue[0], blue[1], 0});

    while (!queue.isEmpty()) {
      int[] curr = queue.poll();
      int redY = curr[0];
      int redX = curr[1];
      int blueY = curr[2];
      int blueX = curr[3];
      int time = curr[4];

      if (time >= 10) {
        return -1;
      }

      for (int i = 0; i < 4; i++) {
        int newRedY = redY;
        int newRedX = redX;
        int newBlueY = blueY;
        int newBlueX = blueX;

        boolean redInHole = false;
        boolean blueInHole = false;

        // 빨간 구슬 이동
        while (map[newRedY + dy[i]][newRedX + dx[i]] != '#' && map[newRedY][newRedX] != 'O') {
          newRedY += dy[i];
          newRedX += dx[i];
          if (map[newRedY][newRedX] == 'O') {
            redInHole = true;
            break;
          }
        }

        // 파란 구슬 이동
        while (map[newBlueY + dy[i]][newBlueX + dx[i]] != '#' && map[newBlueY][newBlueX] != 'O') {
          newBlueY += dy[i];
          newBlueX += dx[i];
          if (map[newBlueY][newBlueX] == 'O') {
            blueInHole = true;
            break;
          }
        }

        if (blueInHole) continue; // 파란 구슬이 구멍에 빠지면 무시
        if (redInHole) return time + 1; // 빨간 구슬만 구멍에 빠진 경우 성공

        // 두 구슬이 같은 위치에 있는 경우
        if (newRedY == newBlueY && newRedX == newBlueX) {
          // red가 더 많이 이동했으면, red에서 빼줘야 한다., 겹치는 원인
          if (Math.abs(newRedY - redY) + Math.abs(newRedX - redX)
              > Math.abs(newBlueY - blueY) + Math.abs(newBlueX - blueX)) {
            newRedY -= dy[i];
            newRedX -= dx[i];
          } else {
            newBlueY -= dy[i];
            newBlueX -= dx[i];
          }
        }
        queue.add(new int[] {newRedY, newRedX, newBlueY, newBlueX, time + 1});
      }
    }
    return -1;
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
