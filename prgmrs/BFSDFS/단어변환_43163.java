package prgmrs.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class 단어변환_43163 {

  private static boolean used[];
  private static int answer;
  private static int n;

  public int solution(String begin, String target, String[] words) {
    n = words.length;
    answer = 987654321;
    used = new boolean[n];

    dfs(words, 0, n, begin, target, 0);
    if (answer == 987654321) return 0;
    else return answer;
  }

  public static void dfs(
      String[] words, int depth, int length, String now, String target, int cnt) {
    // System.out.println("now : "+now+" cnt : "+ cnt+" depth: "+ depth );

    if (depth == n || now.equals(target)) {
      if (now.equals(target)) {
        answer = Math.min(cnt, answer);
        return;
      }
    }
    for (int i = 0; i < n; i++) {
      if (!used[i]) {
        if (getDiff(now, words[i])) {
          used[i] = true;
          dfs(words, depth + 1, length, words[i], target, cnt + 1);
          used[i] = false;
        }
      }
    }
  }

  public static boolean getDiff(String first, String second) {
    int diff = 0;

    for (int i = 0; i < first.length(); i++) {
      if (first.charAt(i) != second.charAt(i)) diff++;
    }
    if (diff == 1) return true;
    else return false;
  }

  class Solution {

    private static boolean[] used;
    private static int[] cost;
    private static int min;

    public int solution(String begin, String target, String[] words) {
      int answer = 0;
      min = 987654321;
      cost = new int[words.length];

      used = new boolean[words.length];
      bfs(begin, target, words);
      return min == 987654321 ? 0 : min;
    }

    public static void bfs(String begin, String target, String[] words) {

      Queue<Integer> q = new LinkedList<>();
      for (int i = 0; i < words.length; i++) {
        String curr = words[i];
        if (getDiff(begin, curr)) {
          cost[i] += 1;
          used[i] = true;
          q.offer(i);
        }
      }
      System.out.println(q);
      while (!q.isEmpty()) {

        int now = q.poll();
        String s = words[now];

        if (words[now].equals(target)) {
          min = Math.min(min, cost[now]);
          break;
        }

        for (int i = 0; i < words.length; i++) {
          if (!used[i] && getDiff(s, words[i])) {
            used[i] = true;
            cost[i] = cost[now] + 1;
            q.offer(i);
          }
        }
      }
    }

    public static boolean getDiff(String a, String target) {
      int diff = 0;
      for (int i = 0; i < a.length() && i < target.length(); i++) {
        if (a.charAt(i) != target.charAt(i)) diff += 1;
      }

      return diff <= 1;
    }
  }
}
