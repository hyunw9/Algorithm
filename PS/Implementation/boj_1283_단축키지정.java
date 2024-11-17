package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_1283_단축키지정 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    // boolean[] map = new boolean[100];
    HashMap<Character, String> map = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String line = br.readLine();
      String[] arr = line.split(" ");
        char key ;
      // 각 단어 첫번째의 인덱스가 가능하면, 걔를 지정
      // 만약 안된다면, 각 단어의 첫글자를 순회하며 검색,
      boolean flag = false;
      // 그래도 안된다면 각 단어의 내부들을 순회하며 검색
      // 비교는 무조건 소문자로.
      int idx = 0;
      for (int j = 0; j < arr.length; j++) {
        char first = arr[j].charAt(0);
        
        if (!map.containsKey(Character.toUpperCase(first))&&!map.containsKey(Character.toLowerCase(first))&&!flag) {
          map.put(first,line.substring(idx,line.length()));
          flag = true;
        key = first;
        
        }
        idx+=arr[j].length()+1;
      }
      if(!flag){
        for(int j = 1 ; j < line.length(); j++){
            char curr = line.charAt(j);
            if(curr == ' ') continue;
            if(!map.containsKey(Character.toUpperCase(curr))&&!map.containsKey(Character.toLowerCase(curr))){
                map.put(curr,line.substring(j,line.length()));
                key=curr;
                flag= true;
                break;
            }
        }
      }

      StringBuilder sb = new StringBuilder();
      boolean shortcut = false;
      for(int j = 0; j<line.length(); j++){
        char curr = line.charAt(j);
        if(map.containsKey(curr)&&map.get(curr).equals(line.substring(j,line.length()))&&!shortcut){
            sb.append("[").append(curr).append("]");
            shortcut = true;
            map.put(curr,".");
        }else{
            sb.append(curr);
        }
      }
      bw.write(sb.toString()+"\n");
    //   System.out.println(map);
    }

    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}

/*
 ** 간략한 풀이 :
 */
