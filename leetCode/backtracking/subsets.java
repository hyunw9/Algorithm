package leetCode.backtracking;

import java.util.*;

public class subsets {
    class Solution {
        private static boolean[] used; 
        private static List<List<Integer>> ss; 
        private static int[] arr;
        private static Set<int[]> set;
    
        public List<List<Integer>> subsets(int[] nums) {
            arr = nums;
            set = new HashSet<>();
    
            used = new boolean[nums.length];
            ss = new LinkedList<>();
            dfs(new ArrayList<>(), 0);
            return ss;
        }
    
        public static void dfs(ArrayList<Integer> nums, int idx){
    
            if(idx == arr.length){
                ss.add(new ArrayList(nums));
                return ;
            }
    
                    nums.add(arr[idx]);
                    dfs(nums,idx+1);
                    nums.remove(nums.size()-1);
                    dfs(nums,idx+1);
                    // dfs()
                
            
        }
    }
        
}
