package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class boj_2800_괄호제거 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int t;
  private static boolean[] wordCheck;
  private static char[] arr;
  private static ArrayList<int[]> g;
  private static ArrayList<String> ans;
  private static Set<String> answer;

  public static void main(String[] args) throws IOException {
    init();
    Stack<Integer> stack = new Stack();
    String line = br.readLine();
    arr = line.toCharArray();
    wordCheck = new boolean[arr.length];
    g = new ArrayList<>();
    ans = new ArrayList<>();
    answer = new HashSet<>();

    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == '(') {
        stack.add(i);
      } else if (arr[i] == ')') {
        int[] pair = new int[]{stack.pop(), i};
        g.add(pair);
      }
    }
    boolean[] used = new boolean[g.size()];
    Arrays.fill(used, false);
    t = g.size();
    dfs(0, used);
    answer.remove(line);

    for (String a : answer) {
      ans.add(a);
    }
    Collections.sort(ans);
    for (String a : ans) {
      bw.write(a + "\n");
    }
    close();

  }

  public static void dfs(int depth, boolean[] used) {
    if (depth == t) {
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < arr.length; i++) {
        if (wordCheck[i]) {
          continue;
        }
        sb.append(arr[i]);
      }
      answer.add(sb.toString());
      return;
    }

    dfs(depth + 1, used);
    used[depth] = true;
    int[] c = g.get(depth);
    wordCheck[c[0]] = true;
    wordCheck[c[1]] = true;
    dfs(depth + 1, used);
    wordCheck[c[0]] = false;
    wordCheck[c[1]] = false;
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
