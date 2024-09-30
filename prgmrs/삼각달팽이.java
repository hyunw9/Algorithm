package prgmrs;

import java.util.*;

public class 삼각달팽이 {

  class Solution {
    private static int cnt;
    private static int[][] arr;
    private static int[] dy = {1, 0, -1};
    private static int[] dx = {0, 1, -1};

    public int[] solution(int n) {
      int[] answer = {};

      arr = new int[n][n];
      int i = 0;
      int j = 0;
      int num = 1;
      int len = n;
      int count = 0;
      int dir = 0;
      while (len > 0) {
        arr[i][j] = num++;
        count += 1;

        if (count == len) {
          count = 0;
          dir = (dir + 1) % 3;
          len -= 1;
        }

        i += dy[dir];
        j += dx[dir];
      }

      ArrayList<Integer> ans = new ArrayList<>();
      for (int y = 0; y < n; y++) {
        for (int x = 0; x < n; x++) {
          if (arr[y][x] != 0) ans.add(arr[y][x]);
        }
      }

      return ans.stream().mapToInt(Integer::intValue).toArray();
    }
  }
}
