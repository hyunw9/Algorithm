package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class boj_6443_애너그램 {


  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int[] visited;
  private static char[] arr;
  private static int len;
  private static Set<String> set;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    //같은 단어도 한번만 출력+ 알파벳 순서로 출력
    for(int i = 0 ; i < n ; i++){
      String line = br.readLine();
      visited = new int[26];
      arr = line.toCharArray();
      for(int j= 0 ; j < arr.length; j ++){
        visited[arr[j] - 'a']+=1;
      }
      len = line.length();
      set = new TreeSet<>();
      dfs(0, new StringBuilder());
      for (String c : set) {
        System.out.println(c);
      }
    }
    close();
  }

  public static void dfs(int cnt, StringBuilder curr) {
    if (cnt == len) {
      set.add(curr.toString());
      return;
    }

    for (int i = 0; i < 26; i++) {
      if (visited[i] > 0) {
        visited[i] -= 1;
        curr.append((char) (i + 'a'));
        dfs(cnt + 1, curr);
        curr.deleteCharAt(curr.length() - 1);
        visited[i] += 1;
      }
    }
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
