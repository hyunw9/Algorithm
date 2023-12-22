package PS.leetCode.ArraysHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class group_anagrams {

  class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      List<List<String>> strLists = new ArrayList<>();
      HashMap<String,List<String>> map = new HashMap<>();
      for(int i = 0; i < strs.length; i++){
        char[] arr = strs[i].toCharArray();
        Arrays.sort(arr);
        String s = new String(arr);

        if(map.containsKey(s)){
          map.get(s).add(strs[i]);
        }else{
          ArrayList<String> al = new ArrayList<>();
          al.add(strs[i]);
          map.put(s,al);
        }

      }

      for(List<String> list : map.values()){
        strLists.add(list);
      }
      return strLists;
    }

  }

}
