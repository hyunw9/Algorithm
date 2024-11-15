package leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Islands_and_treasure {
  class Solution {
    public void islandsAndTreasure(int[][] grid) {
      Queue<int[]> q = new LinkedList<>();
      int n = grid.length;
      int m = grid[0].length;
      int[] dx = {0, 0, -1, 1};
      int[] dy = {-1, 1, 0, 0};
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (grid[i][j] == 0) {
            q.offer(new int[] {i, j});
          }
        }
      }

      while (!q.isEmpty()) {
        int[] curr = q.poll();

        int y = curr[0];
        int x = curr[1];

        for (int i = 0; i < 4; i++) {
          int ny = dy[i] + y;
          int nx = dx[i] + x;

          if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

          if (grid[y][x] + 1 < grid[ny][nx]) {
            grid[ny][nx] = grid[y][x] + 1;
            q.offer(new int[] {ny, nx});
          }
        }
      }
    }
  }
}
