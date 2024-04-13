package leetCode.ArraysHashing;

public class two_sum {

  class Solution {
    public int[] twoSum(int[] nums, int target) {
      int[] output = new int[nums.length] ;
      for(int i = 0 ; i < nums.length-1 ; i ++){
        for(int j = i+1; j<nums.length; j++){
          if(nums[i]+nums[j]==target){
            output= new int[]{i,j};
          }
        }
      }
      return output;
    }
  }
}
