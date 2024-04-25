package leetCode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class combination_sum {

  public static int[]arr;
  public static List<List<Integer>> list ;
  public static int t;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    t= target;
    list = new ArrayList<>();
    Arrays.sort(candidates);
    combi(candidates,new ArrayList<>(), 0, 0);
    return list;
  }

  public static void combi(int[] candidates, List<Integer> now , int curr, int start){
    if(curr > t) return;
    else if(curr == t) {
      list.add(new ArrayList<>(now));
    }else {
      for(int i = start ; i < candidates.length; i++){
        if(curr + candidates[i] > t) continue;
        now.add(candidates[i]);
        combi(candidates,now,curr + candidates[i] , i);
        now.remove(now.size()-1);
      }
    }
  }

}
