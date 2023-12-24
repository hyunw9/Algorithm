package PS.leetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class three_sum {
  public List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> set = new HashSet<>();

    Arrays.sort(nums);
    for(int i = 0; i<nums.length-2;i++){
      int f = nums[i];
      if(f>0){
        break;
      }


      int target = 0-f;

      int s =i+1;
      int t = nums.length-1;
      for(int j = i+1;j<nums.length-1;j++){

        if(nums[s]+nums[t] > target){
          t-=1;
        }else if(nums[s]+nums[t] <target){
          s++;
        }else if(nums[s]+nums[t]==target){
          List<Integer> sums = new ArrayList<>();
          sums.add(nums[i]);
          sums.add(nums[s]);
          sums.add(nums[t]);
          set.add(sums);
          s++;
        }

      }

    }
    return new ArrayList<>(set);
  }

}
