package prgmrs;

import java.util.*;

public class 혼자놀기의달인_131130 {

  class Solution {

    private static List<Integer> arr;
    private static boolean[] used;
    private static int n;
    private static int depth;

    public int solution(int[] cards) {
      int answer = 0;
      n = cards.length;
      arr = new ArrayList<>();
      used = new boolean[n + 1];

      for (int i = 0; i < n; i++) {
        if (!used[i + 1]) {
          depth = 1;
          used[i + 1] = true;
          dfs(cards[i], cards);
          arr.add(depth);
        }
      }
      System.out.println(arr);
      if (arr.size() < 2) return 0;
      else {
        Collections.sort(arr, Collections.reverseOrder());
        return arr.get(0) * arr.get(1);
      }
    }

    public static void dfs(int x, int[] cards) {
      if (!used[x]) {
        used[x] = true;
        depth += 1;
        dfs(cards[x - 1], cards);
      }
    }
  }
}
