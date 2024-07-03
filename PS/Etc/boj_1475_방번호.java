package PS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class boj_1475_방번호 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static HashMap<Character, Integer> map ;

  private static int answer;
  private static int six;
  private static int nine;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    map = new HashMap<>();
    six = 0;
    nine = 0;
    answer = Integer.MIN_VALUE;
    for (int i = 0; i < line.length(); i++) {
      char now = line.charAt(i);
      if(now == '6' ||now == '9'){
        if(six > nine ){
          if(map.get('9') == null) {
            map.putIfAbsent('9', 1);
          }else{
            map.put('9',map.get('9')+1);
          }
          nine ++;
        }else{
          if(map.get('6') == null) {
            map.putIfAbsent('6', 1);
          }else{
            map.put('6',map.get('6')+1);
          }
          six++;
        }
      }else{
        if(map.get(now) == null) {
          map.putIfAbsent(now, 1);
        }else{
          map.put(now,map.get(now)+1);
        }
      }
    }
    for (Character key : map.keySet()) {
      answer = Math.max(answer,map.get(key));
    }
    bw.write(answer+"");
    close();
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
