package PS.Djikstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1238_파티 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); //마을
    int m = Integer.parseInt(st.nextToken()); //길 개수
    int x = Integer.parseInt(st.nextToken()); //목적지

    int[] cost = new int[n + 1];
    Arrays.fill(cost, 987654321);
    ArrayList<Node>[] arr = new ArrayList[n + 1];
    boolean[] used = new boolean[n + 1];

    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[start].add(new Node(end, c));
    }
    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
    cost[x] = 0;
    used[x] = true;
    pq.add(new Node(x, cost[x]));
    while (!pq.isEmpty()) {

      Node now = pq.poll();

      for (Node next : arr[now.num]) {
        if (cost[next.num] > cost[now.num] + next.cost) {
          cost[next.num] = cost[now.num] + next.cost;
          pq.add(new Node(next.num, cost[next.num]));
        }
      }
    }
    int[] newc = new int[n + 1];
    for (int i = 1; i <= n; i++) {

      Arrays.fill(newc,Integer.MAX_VALUE);
      newc[i] = 0;

      if (i == x) {
        continue;
      }


      pq.add(new Node(i, newc[i]));
      while (!pq.isEmpty()) {
        Node now = pq.poll();
        for (Node next : arr[now.num]) {
          if (newc[next.num] > newc[now.num] + next.cost) {
            newc[next.num] = newc[now.num] + next.cost;
            //System.out.println("now.num: "+ now.num+" next.num: "+next.num+ " next.cost: "+next.cost);
            pq.add(new Node(next.num, newc[next.num]));
          }
        }
      }

      cost[i]+=newc[x];

    }
    int max = 0;
    for (int i = 1; i <= n; i++) {
      max = Math.max(cost[i], max);
    }

    bw.write(max + "");
    close();
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

  private static class Node {

    int num;
    int cost;

    public Node(int num, int cost) {
      this.num = num;
      this.cost = cost;
    }
  }

}
