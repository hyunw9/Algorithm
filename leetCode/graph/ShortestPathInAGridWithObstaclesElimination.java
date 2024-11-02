package leetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
  class Solution {
    public int shortestPath(int[][] grid, int k) {
      int n = grid.length;
      int m = grid[0].length;
      int[] dx = {0, 0, -1, 1};
      int[] dy = {-1, 1, 0, 0};
      int ans = -1;
      int[][] cmap = new int[grid.length][grid[0].length];
      boolean[][][] used = new boolean[k + 1][grid.length][grid[0].length];

      Queue<int[]> q = new LinkedList<>();

      if (grid[0][0] == -1) return -1;
      q.offer(new int[] {0, 0, 0, 0});
      used[0][0][0] = true;

      while (!q.isEmpty()) {
        int[] curr = q.poll();

        int y = curr[0];
        int x = curr[1];
        int obs = curr[2];
        int cnt = curr[3];
        // System.out.println("y : "+ y + " x : "+ x + " obs: "+ obs + " cnt : "+ cnt);
        // if(obs>=k) continue;

        if (y == n - 1 && x == m - 1) {
          return cnt;
          // System.out.println(Arrays.deepToString(cmap));
        }

        for (int i = 0; i < 4; i++) {
          int ny = dy[i] + y;
          int nx = dx[i] + x;

          if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;

          if (grid[ny][nx] == 1) {
            // System.out.println("ny : "+ ny + " nx : "+ nx);
            if (obs + 1 > k) continue;

            if (!used[obs + 1][ny][nx]) {
              used[obs + 1][ny][nx] = true;
              cmap[ny][nx] = cnt + grid[ny][nx];
              q.offer(new int[] {ny, nx, obs + 1, cnt + 1});
            }
          } else {
            if (!used[obs][ny][nx]) {
              used[obs][ny][nx] = true;
              cmap[ny][nx] = cnt + grid[ny][nx];
              q.offer(new int[] {ny, nx, obs, cnt + 1});
            }
          }
        }
      }
      return ans;
    }
  }
}
