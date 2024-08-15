package PS.Dfs;

import java.io.*;
import java.util.*;

public class boj_20924_트리의기둥과가지 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Node>[] tree;
  private static boolean[] used;
  private static int body;
  private static int leaf;
  private static int giga;

  public static class Node {
    int val;
    int cost;

    public Node(int val, int cost) {
      this.val = val;
      this.cost = cost;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int root = Integer.parseInt(st.nextToken());
    used = new boolean[n + 1];
    tree = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++) {
        tree[i] = new ArrayList<>();
    }
    for (int i = 0; i < n - 1; i++) {
        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int cost = Integer.parseInt(st.nextToken());
        tree[from].add(new Node(to, cost));
        tree[to].add(new Node(from, cost));
    }
    // 기둥 찾기
    used[root] = true;
    findBody(root, 0);
    
    used[giga] = true;
    findDist(giga, 0);

    System.out.println(body + " " + leaf);
    close();
}

public static void findBody(int node, int cnt) {
    body = Math.max(body, cnt);
    giga = node;

    int children = 0;
    int nextNode = -1;
    int nextCost = 0;

    for (Node curr : tree[node]) {
        if (!used[curr.val]) {
            children++;
            nextNode = curr.val;
            nextCost = curr.cost;
        }
    }

    if (children != 1) {
        return;
    }

    used[nextNode] = true;
    findBody(nextNode, cnt + nextCost);
}

public static void findDist(int node, int cnt) {
    leaf = Math.max(leaf, cnt);

    for (Node curr : tree[node]) {
        if (!used[curr.val]) {
            used[curr.val] = true;
            findDist(curr.val, cnt + curr.cost);
        }
    }
}


  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
