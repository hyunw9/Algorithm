package leetCode.greedy;

public class maximum_subarray {
  public int maxSubArray(int[] nums) {
    int max = -1000;

    if (nums.length == 1) {
      return nums[0];
    }

    for (int i = 0; i < nums.length; i++) {
      int curr = nums[i];
      int idx = i + 1;
      max = Math.max(max, curr);

      while (idx < nums.length) {
        curr += nums[idx];
        max = Math.max(max, curr);
        idx += 1;
        // System.out.println(max);
      }
    }
    return max;
    // prefix?
    // [2,-3,4,-2,2,1,-1,4]
    //  지금부터 새로 시작하기 vs 이전값들이랑 비교하기
  }
}
