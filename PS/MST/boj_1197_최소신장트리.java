package PS.MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_1197_최소신장트리 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static class Node implements Comparable<Node> {
    private int index;
    private int weight;

    public Node(int index, int weight) {
      this.index = index;
      this.weight = weight;
    }

    public int getIndex() {
      return index;
    }

    public int getWeight() {
      return weight;
    }

    @Override
    public int compareTo(Node o) {
      return this.weight - o.weight;
    }
  }

  private static List<List<Node>> graph;
  private static boolean[] visited;
  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    graph = new ArrayList<>(V);
    visited = new boolean[V];
    for (int i = 0; i < V; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()) - 1;
      int v = Integer.parseInt(st.nextToken()) - 1;
      int w = Integer.parseInt(st.nextToken());
      graph.get(u).add(new Node(v, w));
      graph.get(v).add(new Node(u, w));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(0, 0));

    int answer = 0;
    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex();

      if (visited[now]) continue;
      visited[now] = true;
      answer += node.getWeight();

      for (Node next : graph.get(now)) {
        if (!visited[next.getIndex()]) {
          pq.add(next);
        }
      }
    }

    bw.write(answer + "");
    close();
  }

  public static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

}
