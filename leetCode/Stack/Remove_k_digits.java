package leetCode.Stack;

import java.util.ArrayDeque;

public class Remove_k_digits {

  public String removeKdigits(String num, int k) {
    ArrayDeque<Integer> dq = new ArrayDeque<>();

    for(int i = 0 ; i< num.length() ; i++){
      int tmp = num.charAt(i)-'0';

      while(!dq.isEmpty() && tmp< dq.peekLast() && k>0){
        dq.pollLast();
        k--;
      }

      dq.addLast(tmp);
    }

    StringBuilder sb = new StringBuilder();
    System.out.println(dq);
    while(k>0 && !dq.isEmpty()){
      dq.pollLast();
      k--;
    }

    while(!dq.isEmpty()){
      sb.append(dq.pollLast());
    }
    sb.reverse();
    while(sb.length() > 0 && sb.charAt(0)=='0'){
      sb.deleteCharAt(0);
    }

    if(sb.length() > 0 ){
      return sb.toString();
    }else{
      return "0";
    }

  }

}
