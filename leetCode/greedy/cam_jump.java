package leetCode.greedy;

import java.util.*; 

public class cam_jump {
  class Solution {
    public boolean canJump(int[] nums) {
      Queue<int[]> q = new LinkedList<>();

      boolean[] used = new boolean[nums.length];
      Arrays.fill(used, false);
      used[0] = true;
      q.offer(new int[] {0, nums[0]});

      while (!q.isEmpty()) {
        int[] curr = q.poll();
        System.out.println(Arrays.toString(curr));

        if (curr[0] == nums.length - 1) {
          return true;
        }

        if (curr[1] == 0) continue;

        int loc = curr[0];
        int idx = 1;
        while (idx <= curr[1]) {

          if (idx + loc < nums.length && !used[loc + idx]) {
            used[loc + idx] = true;
            q.offer(new int[] {loc + idx, nums[loc + idx]});
          }
          if (loc - idx >= 0 && !used[loc - idx]) {
            used[loc - idx] = true;
            q.offer(new int[] {loc - idx, nums[loc - idx]});
          }
          idx += 1;
        }
      }
      return false;
    }

    public boolean canJump2(int[] nums) {
      int goal = nums.length - 1;

      for (int i = nums.length - 2; i >= 0; i--) {
        if (nums[i] + i >= goal) {
          goal = i;
        }
      }
      return goal == 0;
    }
  }
}
