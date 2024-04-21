package leetCode.dailyQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Find_Path_if_Exists_in_Graph {
  public boolean validPath(int n, int[][] edges, int source, int destination) {
    ArrayList<Integer>[] adj = new ArrayList[n + 1];

    for (int i = 0; i < n; i++) {
      adj[i] = new ArrayList<>();
    }

    for (int i = 0; i < edges.length; i++) {
      adj[edges[i][0]].add(edges[i][1]);
      adj[edges[i][1]].add(edges[i][0]);
    }

    boolean[] used = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(source);
    used[source] = true;
    while (!q.isEmpty()) {
      int now = q.poll();
      if (now == destination) {
        return true;
      }
      for (int a : adj[now]) {
        if (!used[a]) {
          used[a] = true;
          q.add(a);
        }
      }
    }
    return false;
  }
}
