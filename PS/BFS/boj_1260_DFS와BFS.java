package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_1260_DFS와BFS {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Integer>[] arr;
  private static ArrayDeque<Integer> q;

  private static boolean[] check;
  private static int n;
  private static int m;
  private static int v;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    v = Integer.parseInt(st.nextToken());
    arr = new ArrayList[n + 1];
    q = new ArrayDeque<>();
    check = new boolean[n + 1];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 1; i <= m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      arr[start].add(end);
      arr[end].add(start);
    }
    for (int i = 1; i <= n; i++) {
      arr[i].sort((o1,o2) -> o1-o2);
    }
    dfs_stack();
    //dfs_recursion(v);
    bw.write("\n");
    bw.flush();
    Arrays.fill(check, false);
    bfs_queue();
    bw.write("\n");
    close();
  }

  public static void dfs_stack() throws IOException {
    Stack<Integer> stack = new Stack<>();

    stack.push(v); //시작점 입력
    bw.write(v + " ");
    check[v] = true;

    while (!stack.isEmpty()) {
      boolean flag = false;
      int n = stack.peek();
      for (Integer node : arr[n]) {
        if (!check[node]) {
          stack.push(node);
          bw.write(node + " ");
          check[node] = true;
          flag = true;
          break;
        }
      }
      if (!flag) {
        stack.pop();
      }
    }
  }

  public static void dfs_recursion(int num) throws IOException {
    check[num] = true;
    bw.write(num + " ");
    for (Integer node : arr[num]) {
      if (!check[node]) {
        dfs_recursion(node);
      }
    }
  }

  private static void bfs_queue() throws IOException {
    q.addLast(v);
    check[v] = true;
    while (!q.isEmpty()) {
      int now = q.pollFirst();
      for (Integer node : arr[now]) {
        if (check[node]) {
          continue;
        }
        check[node] = true;
        q.addLast(node);
      }
      bw.write(now + " ");

    }
    }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }
}
