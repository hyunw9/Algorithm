package leetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class cheapest_flight_path {
  class Solution {
    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {
      HashMap<Integer, List<int[]>> g = new HashMap<>();

      for (int[] fly : flights) {
        g.computeIfAbsent(fly[0], x -> new ArrayList<>()).add(new int[] {fly[1], fly[2]});
      }
      PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
      pq.offer(new int[] {src, 0, 0});

      while (!pq.isEmpty()) {
        int[] curr = pq.poll();
        int node = curr[0];
        int cost = curr[1];
        int cnt = curr[2];

        if (node == dst) return cost;

        if (cnt <= k) {
          if (!g.containsKey(node)) continue;

          for (int[] next : g.get(node)) {
            pq.offer(new int[] {next[0], cost + next[1], cnt + 1});
          }
        }
      }
      return -1;
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
      int[] price = new int[n];

      Arrays.fill(price, 987654321);
      price[src] = 0;
      for (int c = 0; c <= k; c++) {
        int[] tmp = Arrays.copyOf(price, n);

        for (int[] next : flights) {
          int start = next[0];
          int end = next[1];
          int cost = next[2];

          if (price[start] == 987654321) continue;

          if (cost + price[start] < tmp[end]) {
            tmp[end] = cost + price[start];
          }
        }
        price = tmp;
      }
      System.out.println(Arrays.toString(price));
      return price[dst] == 987654321 ? -1 : price[dst];
    }
  }
}
