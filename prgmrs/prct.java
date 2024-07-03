package prgmrs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class prct {

  static class Solution {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    private static class Loc {

      int x;
      int y;
      int cnt;

      public Loc(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
      }
    }

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
      String a = "asd";
      int answer = 0;
      int[][] map = new int[102][102];
      Queue<Loc> q = new LinkedList<>();
      boolean[][] visited = new boolean[102][102];

      PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
          return 0;
        }
      });
      pq.clear();
      for (int[] arr : rectangle) {
        //1,1,3,4
        int x1 = arr[0] * 2;
        int y1 = arr[1] * 2;
        int x2 = arr[2] * 2;
        int y2 = arr[3] * 2;
        for (int i = y1; i <= y2; i++) {
          for (int j = x1; j <= x2; j++) {
            map[i][j] = 1;
            if (i == y1 || i == y2 || j == x1 || j == x2)
              map[i][j] = 2;
          }
        }
      }
      visited[characterY * 2][characterX * 2] = true;
      q.add(new Loc(characterX * 2, characterY * 2, 1));
      while (!q.isEmpty()) {
        Loc now = q.poll();
        if (now.x == itemX * 2 && now.y == itemY * 2) {
          return now.cnt;

        }
        for (int i = 0; i < 4; i++) {
          int nx = now.x + dx[i];
          int ny = now.y + dy[i];
          if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102)
            continue;
          if (visited[ny][nx])
            continue;
          //가장자리가 아니면
          if (map[ny][nx] != 2)
            continue;
          visited[ny][nx] = true;
          q.add(new Loc(nx, ny, now.cnt + 1));

        }
      }

      return answer;
    }
  }

}
