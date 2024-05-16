package prgmrs.BFSDFS;

import java.util.*;

public class 무인도여행_154540 {

  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static ArrayList<Integer> ans;
  private static int maxValue;
  private static boolean[][] used;

  public static void dfs(int[][] map, int y, int x, int curr) {

    if (x < 0 || x >= map[0].length || y < 0 || y >= map.length ||
        used[y][x] || map[y][x] < 1) {
      return; //베이스케이스
    }

    used[y][x] = true;
    maxValue = Math.max(maxValue, curr + map[y][x]);
    for (int i = 0; i < 4; i++) {

      int nx = dx[i] + x;
      int ny = dy[i] + y;
      dfs(map, ny, nx, maxValue);
    }
  }

  public int[] solution(String[] maps) {
    int[] answer = {};
    ans = new ArrayList<>();

    int[][] map = new int[maps.length][maps[0].length()];
    used = new boolean[map.length][map[0].length];
    for (int i = 0; i < map.length; i++) {
      String line = maps[i];
      for (int j = 0; j < map[0].length; j++) {
        if (line.charAt(j) == 'X') {
          map[i][j] = 0;
        } else {
          map[i][j] = line.charAt(j) - '0';
        }
      }
    }
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (!used[i][j] && map[i][j] > 0) {
          maxValue = 0;
          dfs(map, i, j, maxValue);
          ans.add(maxValue);
        }
      }
    }
    Collections.sort(ans);
    if (ans.size() == 0) {
      return new int[]{-1};
    }
    return ans.stream().mapToInt(Integer::intValue).toArray();
  }


}
