package leetCode.ArraysHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
  class Solution {
    public int[] topKFrequent(int[] nums, int k) {
      HashMap<Integer,Integer> map = new HashMap<>();
      int[] output = new int[k];
      for(int i = 0; i < nums.length; i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      }
      PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

      for(Map.Entry entry : map.entrySet()){
        pq.add(entry);
      }
      for(int i = 0; i<k;i++){
        output[i] = pq.poll().getKey();
      }
      return output;
    }
  }
}
