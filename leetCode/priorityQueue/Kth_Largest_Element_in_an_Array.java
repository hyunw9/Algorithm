package leetCode.priorityQueue;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
  public int findKthLargest(int[] nums, int k) {

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

    for (int v : nums) {
      pq.offer(v);
    }
    int ans = 0;
    while (k-- > 0) {
      ans = pq.poll();
    }
    return ans;
  }
}
