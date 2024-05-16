package prgmrs.BFSDFS;

import static java.lang.System.currentTimeMillis;

import java.util.*;

public class 무인도여행_154540 {

  private static int[] dx = {-1, 1, 0, 0};
  private static int[] dy = {0, 0, -1, 1};
  private static ArrayList<Integer> ans;
  private static int maxValue;
  private static boolean[][] used;

  public static void main(String[] args) {
    long start = System.nanoTime();
    String[] maps = {
        "X591XX24X1", "XX13X5X9XX", "X12345678X", "X9X8X7X6X5",
        "4321XXXXX1", "1X2X3X4X5X", "9X8X7X6X5X", "XXXX1234XX",
        "12X34X56X7", "X91X8X7X6X"
    };

    int[] result = solution(maps);
    long end = System.nanoTime();
    System.out.println("걸린 시간 : " + (double) ((end - start) / 1000) + " 초");
    System.out.println(Arrays.toString(result));  // 결과 출력
  }

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

  public static int[] solution(String[] maps) {
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
    Stack<int[]> stack = new Stack<>();
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length; j++) {
        if (!used[i][j] && map[i][j] > 0) {
          maxValue = 0;
          stack.push(new int[]{i, j});

          while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int y = curr[0];
            int x = curr[1];
            if (y < 0 || x < 0 || y >= map.length || x >= map[0].length || used[y][x]
                || map[y][x] < 1) {
              continue;
            }

            used[y][x] = true;
            maxValue += map[y][x];

            for (int k = 0; k < 4; k++) {
              int nx = dx[k] + x;
              int ny = dy[k] + y;
              stack.push(new int[]{ny, nx});
            }
          }
//          dfs(map, i, j, maxValue);
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
