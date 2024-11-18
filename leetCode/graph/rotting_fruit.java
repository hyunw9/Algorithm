package leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class rotting_fruit {
  class Solution {
    public int orangesRotting(int[][] grid) {
      int minute = 0;

      Queue<int[]> q = new LinkedList<>();
      int n = grid.length;
      int m = grid[0].length;

      int[] dx = {0, 0, -1, 1};
      int[] dy = {-1, 1, 0, 0};

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 2) {
            q.offer(new int[] {i, j, 0});
          }
        }
      }
      while (!q.isEmpty()) {
        int[] curr = q.poll();

        int y = curr[0];
        int x = curr[1];
        int time = curr[2];

        minute = Math.max(time, minute);

        for (int i = 0; i < 4; i++) {
          int ny = y + dy[i];
          int nx = x + dx[i];

          if (ny < 0 || nx < 0 || ny >= n || nx >= m || grid[ny][nx] == 0 || grid[ny][nx] == 2)
            continue;
          grid[ny][nx] = 2;
          q.offer(new int[] {ny, nx, time + 1});
        }
      }

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 1) return -1;
        }
      }
      return minute;
    }
  }
}
