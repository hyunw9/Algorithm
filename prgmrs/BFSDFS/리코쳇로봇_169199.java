package prgmrs.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇_169199 {

  private static int[] dx = {0, 0, -1, 1};
  private static int[] dy = {-1, 1, 0, 0};
  private static char[][] map;
  private static int min = 987654321;
  private static boolean[][] used;
  private static int n;
  private static int m;
  private static int tx;
  private static int ty;
  Queue<Node> q = new LinkedList<>();

  public int solution(String[] board) {
    int answer = 0;
    n = board.length;
    m = board[0].length();
    map = new char[n][m];
    int sy = 0;
    int sx = 0;

    used = new boolean[n][m];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length(); j++) {
        map[i][j] = board[i].charAt(j);
        if (map[i][j] == 'R') {
          used[i][j] = true;
          q.add(new Node(i, j, 0));
        } else if (map[i][j] == 'G') {
          ty = i;
          tx = j;
        }
      }
    }
    bfs();
    //System.out.println(Arrays.deepToString(map));

    if (min == 987654321) {
      return -1;
    }
    return min;
  }

  public void bfs() {

    while (!q.isEmpty()) {

      Node now = q.poll();
      // System.out.println("now.y: "+ now.y+ " now.x: "+ now.x + " c: "+ now.c);
      if (now.y == ty && now.x == tx) {
        min = Math.min(now.c, min);
        //System.out.println("arrived: "+ now.c);
      }

      for (int i = 0; i < 4; i++) {
        int nx = now.x + dx[i];
        int ny = now.y + dy[i];

        while (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] != 'D') {
          nx += dx[i];
          ny += dy[i];
        }
        nx = nx - dx[i];
        ny = ny - dy[i];
        if (map[ny][nx] == 'D') {
          continue;
        }

        if (used[ny][nx]) {
          continue;
        }
        used[ny][nx] = true;
        q.add(new Node(ny, nx, now.c + 1));


      }
    }
  }

  public class Node {

    int y;
    int x;
    int c;

    public Node(int y, int x, int c) {
      this.y = y;
      this.x = x;
      this.c = c;
    }
  }

}
