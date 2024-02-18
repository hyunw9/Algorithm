package prgmrs.완전탐색;

import java.util.ArrayList;

public class 모음사전_84512 {

  static char[] list = {'A','E','I','O','U'};
  static ArrayList<String> arr;
  public int solution(String word) {
    int answer = 0;
    arr= new ArrayList<>();

    dfs(0,"");

    for(int i = 0 ; i < arr.size(); i++){
      if(arr.get(i).equals(word)) break;
      answer++;
    }
    return answer;
  }

  public void dfs(int depth, String curr){
    arr.add(curr);

    if(depth==5) return;

    for(int i = 0 ; i < list.length; i++){
      dfs(depth+1,curr+list[i]);
    }
  }

}
