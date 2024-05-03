package leetCode.dailyQuestion;

import java.io.*;
import java.util.*;
public class largest_positive_integer_that_exists_with_its_negative {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int l = 0;
        int r= nums.length-1;
        while(l<=r){
            if(nums[l] * -1 == nums[r] ){
                return nums[r];
            }else if( nums[l]*-1 >= nums[r]){
                l++;
            }else{
                r--;
            }
        }
        return -1;
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
