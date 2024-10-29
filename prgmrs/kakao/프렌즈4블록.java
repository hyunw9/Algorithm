package prgmrs.kakao;

import java.util.*;

public class 프렌즈4블록 {

  class Solution {
    private static char[][] grid;
    private static int r;
    private static int c;
    private static int score;
    private static boolean[][] used;
    private static Queue<int[]> cleanQ;

    public int solution(int m, int n, String[] board) {

      // 문제를 쪼개기
      // 1. 4칸 검증
      // 2. 점수 추가
      // 3. 지우기
      // 4. 땡기기
      cleanQ = new LinkedList<>();
      used = new boolean[m][n];
      grid = new char[m][n];
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          grid[i][j] = board[i].charAt(j);
        }
      }
      r = m;
      c = n;

      while (true) {
        int cnt = 0;
        used = new boolean[r][c];
        for (int i = 0; i < r - 1; i++) {
          for (int j = 0; j < c - 1; j++) {
            if (check(i, j)) {
              cnt += 1;
              addScore(i, j);
              cleanQ.offer(new int[] {i, j});
            }
          }
        }

        if (cnt == 0) {
          break;
        }

        clean();
        pull();
        // print();
      }
      return score;
    }

    public static boolean check(int y, int x) {
      if (grid[y][x] != ' '
          && grid[y][x] == grid[y + 1][x]
          && grid[y + 1][x] == grid[y][x + 1]
          && grid[y][x + 1] == grid[y + 1][x + 1]
          && grid[y][x] == grid[y + 1][x + 1]) {
        return true;
      }
      return false;
    }

    public static void addScore(int y, int x) {
      if (!used[y][x]) {
        score += 1;
      }
      used[y][x] = true;

      if (!used[y + 1][x]) {
        score += 1;
      }
      used[y + 1][x] = true;

      if (!used[y][x + 1]) {
        score += 1;
      }
      used[y][x + 1] = true;

      if (!used[y + 1][x + 1]) {
        score += 1;
      }
      used[y + 1][x + 1] = true;
    }

    public static void clean() {
      while (!cleanQ.isEmpty()) {
        int[] curr = cleanQ.poll();
        int y = curr[0];
        int x = curr[1];

        grid[y][x] = ' ';
        grid[y + 1][x] = ' ';
        grid[y][x + 1] = ' ';
        grid[y + 1][x + 1] = ' ';
      }
    }

    public static void pull() {
      for (int j = 0; j < c; j++) {

        for (int i = r - 1; i >= 0; i--) {

          if (grid[i][j] == ' ') {
            int idx = i - 1;

            while (idx >= 0 && grid[idx][j] == ' ') {
              idx -= 1;
            }
            // System.out.println("nonEmpty idx ; "+ idx);
            if (idx != i && idx >= 0) {
              grid[i][j] = grid[idx][j];
              grid[idx][j] = ' ';
            }
          }
        }
      }
    }

    public static void print() {
      for (char[] l : grid) {
        System.out.println(Arrays.toString(l));
      }
    }
  }
}
