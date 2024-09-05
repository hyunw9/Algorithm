package leetCode.dynamic_programming.knapsack;

public class partition_equal_subset_sum {
    

class Solution {
    public boolean canPartition(int[] nums) {
        int K=0;
        for(int i = 0 ; i < nums.length; i++){
            K +=nums[i];
        }
        if(K%2==1) return false;

        int[][]dp = new int[nums.length+1][(K/2)+1];
        dp[0][0] =1;
        for(int i =1 ; i <= nums.length; i++){

            for(int k = 1; k<=K/2; k++){
                if(nums[i-1]<=k ){
                    dp[i][k]=Math.max(dp[i-1][k], dp[i-1][k-nums[i-1]]);
                }else{
                    dp[i][k]= dp[i-1][k];
                }
            }
        }
            // System.out.println(Arrays.deepToString(dp));
            // System.out.println(dp[nums.length][K/2]);
            
            return dp[nums.length][K/2]==1;
    }
}

//      1  2  3  4  5  6  7  8  9  10  11  12  13  14  15  16  17  18  19  20  21  22  
// 1    1  1  1  
// 5   
// 11
// 5
}
