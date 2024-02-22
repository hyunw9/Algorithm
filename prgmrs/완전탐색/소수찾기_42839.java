package prgmrs.완전탐색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 소수찾기_42839 {

  static boolean[] isPrime;
  static int max ;
  static int len;
  static boolean[]used;
  static String[] num;
  static Set<Integer> set = new HashSet<>();
  public int solution(String numbers) {
    int answer = 0;
    used= new boolean[numbers.length()];
    num = numbers.split("");
    max = (int)Math.pow(10,numbers.length() );
    len = numbers.length();
    //System.out.println(max);

    isPrime = new boolean[max];
    Arrays.fill(isPrime,true);
    for(int i = 2;i<Math.sqrt(max); i++){
      if(isPrime[i]){
        for(int j =i*i; j<isPrime.length; j+=i){
          isPrime[j] = false;
        }
      }
    }
    isPrime[0]= isPrime[1]= false;


    dfs("",0);
    //소수 맵 만들기
    //조합을 통해서 판별하기.
    for(int v : set){
      if(isPrime[v]) answer++;
    }

    return answer;
  }
  public void dfs(String curr,int depth){
    if(!curr.isEmpty()){ //if(depth == len) 시 set에 add 하고 리턴해줬는데, 이 부분이 틀렸다.
      // 이 부분을 풀어줘야 밑에 반복문으로 내려가서 모든 경우를 탐색한다.
      //System.out.println(curr);
      int val = Integer.parseInt(curr);
      set.add(val);

    }
    for(int i = 0 ; i < num.length; i++){
      if(!used[i]){
        used[i] = true;
        dfs(curr+num[i],i+1);
        used[i]= false;
      }
    }
  }

}
