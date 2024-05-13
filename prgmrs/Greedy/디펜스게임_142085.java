package prgmrs.Greedy;

import java.util.*;

public class 디펜스게임_142085 {
  public int solution(int n, int k, int[] enemy) {
    int round = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int idx = 0;
    for (; idx < k; idx++) {
      if (idx >= enemy.length) break;
      pq.add(enemy[idx]);
    }

    for (int i = idx; i < enemy.length; i++) {
      // 2 4 4
      if (pq.peek() <= enemy[i]) {
        int curr = pq.poll();
        pq.add(enemy[i]);
        n -= curr;
      } else {
        // 4 4 5
        n -= enemy[i];
      }

      if (n < 0) break;
      round += 1;
    }

    return round + pq.size();
  }
}
