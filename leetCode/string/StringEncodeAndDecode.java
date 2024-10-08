package leetCode.string;

import java.util.*;

public class StringEncodeAndDecode {
    class Solution {

        public String encode(List<String> strs) {
            if(strs.size()==0) return "";
            StringBuilder sb = new StringBuilder();
            for ( String str : strs ){
                sb.append(str.length()).append("#").append(str);
            }
            // System.out.println(sb.toString());
            return sb.toString();
        
        }
    
        public List<String> decode(String str) {
            List<String> ans = new ArrayList<>();
            int i = 0 ;
            while(i < str.length()){
    
                int j = i;
                while(str.charAt(j)!='#') j++;
    
                int length = Integer.valueOf(str.substring(i,j));
                // System.out.println(length);
                i =  length + j+1;
                ans.add(str.substring(j+1,i));
            }
            return ans;
        }
    }
    
}
