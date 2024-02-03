package prgmrs.완전탐색;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 전력망을둘로나누기_86971 {

  public int solution(int n, int[][] wires) {
    int answer = Integer.MAX_VALUE;

    //1. 그래프 잇기

    //2. 자르기
    for (int i = 0; i < wires.length; i++) {
      ArrayList<Integer>[] arr = new ArrayList[n + 1];
      Queue<Integer> q = new LinkedList<>();
      ArrayList<Integer> ans = new ArrayList<>();
      boolean[] used = new boolean[n + 1];

      for (int j = 1; j <= n; j++) {
        arr[j] = new ArrayList<>();
      }

      for (int j = 0; j < wires.length; j++) {
        if (i == j) {
          continue;
        }
        int first = wires[j][0];
        int second = wires[j][1];
        arr[first].add(second);
        arr[second].add(first);
        //System.out.println(Arrays.toString(wires[j]));
      }

      for (int j = 1; j <= n; j++) {
        int cnt = 0;

        if (!used[j]) {
          used[j] = true;
          cnt++;
          q.add(j);

        }

        while (!q.isEmpty()) {
          int now = q.poll();

          for (int v : arr[now]) {
            if (!used[v]) {
              used[v] = true;
              q.add(v);
              cnt++;
            }
          }
        }
        if (cnt == 0) {
          continue;
        }
        ans.add(cnt);

      }
      answer = Math.min(answer, Math.abs(ans.get(0) - ans.get(1)));

    }
    //2-1. 두 그래프 차이 세기

    //3. 세면서 max 갱신하기

    return answer;
  }

}
