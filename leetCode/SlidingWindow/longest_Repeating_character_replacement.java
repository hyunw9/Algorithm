package leetCode.SlidingWindow;

import java.util.HashMap;

public class longest_Repeating_character_replacement {

  public int characterReplacement(String s, int k) {
    int window =0;
    int maxR = 0;
    int nonR = 0;
    int ans=0;
    HashMap<Character,Integer> map = new HashMap<>();

    for(int l =0,r=0;r<s.length();r++){
      char now = s.charAt(r);
      map.put(now,map.getOrDefault(now,0)+1);

      maxR = Math.max(maxR,map.get(now));
      window = r - l +1;

      nonR = window - maxR;
      if(nonR <=k){
        ans = Math.max(ans,window);
      }else if( nonR> k){
        map.put(s.charAt(l),map.get(s.charAt(l))-1);
        l++;

      }
    }
    return ans;
  }

}
