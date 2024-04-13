package leetCode.ArraysHashing;

public class Product_of_array_except_self {
  class Solution {
    public int[] productExceptSelf(int[] nums) {
      int [] answer = new int[nums.length];

      int[] a = new int[nums.length];
      int[] b = new int[nums.length];
      a[0] = 1;
      b[nums.length-1]= 1;
      for(int i = 1; i < nums.length; i++){
        a[i] += a[i-1] * nums[i-1];
        b[nums.length-1-i] += b[nums.length-i] * nums[nums.length-i];
      }
      for(int i = 0 ; i < nums.length; i++){
        answer[i] = a[i] * b[i];
      }

      return answer;
    }
  }


}
