package prgmrs.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 숫자변환하기 {
  class Solution {

    private static int answer;
    private static Set<Integer> set;
    private static boolean[] used;

    public int solution(int x, int y, int n) {

      used = new boolean[y + 1];
      Queue<int[]> q = new LinkedList<>();
      used[y] = true;
      q.offer(new int[] {y, 0});
      answer = Integer.MAX_VALUE;

      while (!q.isEmpty()) {

        int[] curr = q.poll();

        int val = curr[0];
        int cnt = curr[1];

        if (val == x) {
          answer = Math.min(answer, cnt);
          break;
        }

        if (val - n > 0 && !used[val - n]) {
          used[val - n] = true;
          q.offer(new int[] {val - n, cnt + 1});
        }
        if (val % 2 == 0 && !used[val / 2]) {
          used[val / 2] = true;
          q.offer(new int[] {val / 2, cnt + 1});
        }
        if (val % 3 == 0 && !used[val / 3]) {
          used[val / 3] = true;
          q.offer(new int[] {val / 3, cnt + 1});
        }
      }
      if (answer == Integer.MAX_VALUE) return -1;
      return answer;
    }
  }
}
