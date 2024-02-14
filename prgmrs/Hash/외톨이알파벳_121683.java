package prgmrs.Hash;

import java.util.HashMap;

public class 외톨이알파벳_121683 {

  public String solution(String input_string) {
    String answer = "";
    //갯수 해시맵
    //나타난 지역 해시맵
    //String 반복하며 알파벳이 나오면 다음 알파벳이 해당 알파벳이 아닐 때 까지 반복 후 , 해시맵에 개수 추가, 나타난 지역 추가 .
    //개수가 2 이상인데, 지역이 2개 이상이면 스트링 추가 .
    HashMap<Character, Integer> cnt = new HashMap<>();
    HashMap<Character, Integer> loc = new HashMap<>();

    for(int i = 0 ; i<input_string.length() ; i ++ ){


      char now = input_string.charAt(i);
      int c = 0;
      for(int j = i ; j <input_string.length(); j++){
        if(input_string.charAt(j)==now){
          c++;
        }else if(input_string.charAt(j)!=now){
          break;
        }
      }
      i = i + c-1;
      cnt.put(now,cnt.getOrDefault(now,0)+c);
      loc.put(now,loc.getOrDefault(now,0)+1);

    }
    for(char key : cnt.keySet()){

      if(cnt.get(key)>=2 && loc.get(key)>=2){
        answer+=key;
      }
    }
    char[] ans = answer.toCharArray();
    Arrays.sort(ans);
    StringBuilder sb = new StringBuilder();

    for(char now : ans){
      sb.append(now);
    }


    String a =  sb.toString();
    if(a.equals("")) return "N";
    else return a;
  }

}
