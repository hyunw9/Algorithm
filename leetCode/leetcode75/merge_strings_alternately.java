package leetCode.leetcode75;

public class merge_strings_alternately {
    public String mergeAlternately(String word1, String word2) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx< word1.length() && idx <word2.length() ){
            sb.append(word1.charAt(idx));
            sb.append(word2.charAt(idx));
            idx++;
        }
        if(word1.length()>word2.length()){
            sb.append(word1.substring(idx,word1.length()));
        }else{
            sb.append(word2.substring(idx,word2.length()));
        }
        return sb.toString();
    }   
}
