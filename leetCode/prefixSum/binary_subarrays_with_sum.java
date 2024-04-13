package leetCode.prefixSum;

import java.util.HashMap;

public class binary_subarrays_with_sum {
  public int numSubarraysWithSum(int[] nums, int goal) {
    //goal 전까지 확장, 만약 goal 초과시 감소하면서 카운드

    HashMap<Integer,Integer> map = new HashMap<>();
    int cnt = 0 ;
    map.put(0,1);
    int prefix = 0;

    for(int i = 0 ; i < nums.length ; i++){
      prefix += nums[i];
      cnt += map.getOrDefault(prefix-goal,0);
      map.put(prefix , map.getOrDefault(prefix,0)+1);
    }
    return cnt;
  }

}
