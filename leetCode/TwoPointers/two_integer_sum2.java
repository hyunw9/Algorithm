package leetCode.TwoPointers;

public class two_integer_sum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l= 0;
        int r =numbers.length -1;
        int[] ans = new int[2];
        while( l < r){

            int sum = numbers[l]+numbers[r];
            // System.out.println(l +" "+ r);
            // if(numbers[l]== target || numbers[r]==target) continue;
            if(sum == target){
                ans[0] = l+1;
                ans[1] = r+1;
                break;
            }
            if(sum < target){
                l+=1;
            }else{
                r-=1;
            }
        }
        return ans;
    }
}
