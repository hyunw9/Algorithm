package PS.leetCode.ArraysHashing;

import java.util.HashMap;
import java.util.TreeMap;

public class Longest_Consecutive_Sequence {
  public int longestConsecutive(int[] nums) {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    int low = Integer.MAX_VALUE;
    int ans = 0;
    int cnt = 0;
    int next = 0;
    for(int num : nums){
      map.put(num,num+1);
      if(num<low){
        low = num;
      }
    }
    String s = "race a, car";

    for(int key: map.keySet()){
      next = map.get(key);
      cnt++;
      if(map.get(next) == null){
        ans = Math.max(ans,cnt);
        cnt =0;
      }else{

        next = map.get(key);
      }
    }

    //System.out.println(map);
    return ans;
  }
}
