package leetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class network_delay_time {
  public int networkDelayTime(int[][] times, int n, int K) {

    // int[][] arr = new int [n+1][n+1];

    // for(int i = 1; i <= n ; i++){
    //     for(int j = 1; j <= n ;j++){
    //         if(i!=j){
    //             arr[i][j]= 987654321;
    //         }else{
    //             arr[i][j] = 0;
    //         }
    //     }
    // }
    // for(int[] t : times){
    //     int start = t[0] ;
    //     int end =t[1];
    //     int cost = t[2];

    //     arr[start][end]=cost;
    // }

    // for(int k = 1; k<= n ; k++){
    //     for(int i = 1; i <= n; i++){
    //         for(int j = 1; j <= n ; j++){
    //             if(arr[i][k]+arr[k][j] < arr[i][j]){
    //                 arr[i][j] = arr[i][k]+arr[k][j];
    //             }
    //         }
    //     }
    // }

    // int[] ans = arr[K];
    // int max = 0;
    // for(int i = 1; i <= n ; i++){
    //     if(ans[i]>=987654321) return -1;
    //     max = Math.max(max,ans[i]);
    // }
    // return max;
    // System.out.println(Arrays.deepToString(arr));
    int[] tot = new int[n + 1];
    int ans = 0;
    Arrays.fill(tot, Integer.MAX_VALUE);
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    boolean[] used = new boolean[n + 1];

    ArrayList<int[]>[] arr = new ArrayList[n + 1];

    for (int i = 0; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int[] t : times) {
      int start = t[0];
      int end = t[1];
      int c = t[2];

      arr[start].add(new int[] {end, c});
    }
    // used[K] = true;
    tot[K] = 0;
    pq.offer(new int[] {K, 0});

    while (!pq.isEmpty()) {
      int[] curr = pq.poll();

      int next = curr[0];
      int cost = curr[1];

      if (used[next]) {
        continue;
      }
      used[next] = true;
      ans = cost;

      // ans += cost;
      for (int[] node : arr[next]) {
        if (!used[node[0]]) {
          // used[node[0]] = true;
          pq.offer(new int[] {node[0], cost + node[1]});
        }
      }
    }

    System.out.println(Arrays.toString(used));

    for (int i = 1; i <= n; i++) {
      if (!used[i]) return -1;
    }
    return ans;
  }
}
