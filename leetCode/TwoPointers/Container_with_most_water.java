package leetCode.TwoPointers;

public class Container_with_most_water {
  class Solution {
    public int maxArea(int[] height) {
      int max = 0;
      int l = 0;
      int r = height.length-1;
      int val= 0;
      while(l<=r){
        int d = r-l;
        val = Math.min(height[r],height[l]);
        max = Math.max(max,d * val);
        if(height[l]<height[r]){
          l++;
        }else{
          r--;
        }
      }
      return max;
    }
  }

}
