package leetCode.graph;

public class max_area_of_island {
  class Solution {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] used;
    private static int n;
    private static int m;
    private static int max;

    public int maxAreaOfIsland(int[][] grid) {
      n = grid.length;
      m = grid[0].length;

      used = new boolean[n][m];
      max = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (!used[i][j] && grid[i][j] == 1) {
            max = Math.max(max, dfs(grid, i, j, 0));
          }
        }
      }
      return max;
    }

    public static int dfs(int[][] grid, int y, int x, int cnt) {
      // System.out.println("y : "+ y + " , x : "+ x );
      if (y < 0 || x < 0 || y >= n || x >= m || used[y][x] || grid[y][x] == 0) {
        return 0;
      }

      used[y][x] = true;

      int area = 1;

      for (int i = 0; i < 4; i++) {
        int ny = y + dy[i];
        int nx = x + dx[i];
        area += dfs(grid, ny, nx, cnt + 1);
      }
      return area;

      // 6 -> but need 5
    }
  }
}
