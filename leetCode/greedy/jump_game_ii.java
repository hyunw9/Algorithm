package leetCode.greedy;

public class jump_game_ii {
  class Solution {
    public int jump(int[] nums) {

      int cnt = 0;
      int goal = nums.length - 1;

      for (int i = 0; i < nums.length; ) {
        if (i >= goal) break;
        int curr = nums[i];
        int maxVal = 0;
        int maxIdx = 0;
        for (int j = i + 1; j <= i + curr; j++) {
          if (j < nums.length && nums[j] >= maxVal) {
            maxVal = nums[j];
            maxIdx = j;
          }
          if (j >= goal) {
            return cnt + 1;
          }
        }
        // 이동
        i = maxIdx;
        cnt += 1;
      }

      return cnt;
    }
  }

  // 2 + 2 > 3 ;
}
