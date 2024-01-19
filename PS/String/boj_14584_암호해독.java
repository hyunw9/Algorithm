package PS.String;

import java.util.*;
import java.io.*;

public class boj_14584_암호해독 {

  private static BufferedReader br;
  private static BufferedWriter bw;


  public static void main(String[] args) throws IOException {
    init();
    char[] arr = new char[26];
    String line = br.readLine();
    HashMap<Character,Character> map = new HashMap<>();
    for(int i = 0 ; i < arr.length; i ++){
      map.put((char) ('A'+i), (char) ('A'+ 17+ i));
      if((char) ('A'+ 17+ i) > 90){
        map.put((char) ('A'+i),(char)('A'+ 17+ i - 91 +'A'));
      }
    }
    StringBuilder sb = new StringBuilder();
    System.out.println(map);
    for(int i = 0 ; i < line.length(); i++) {
      sb.append(map.get(line.charAt(i)));
    }
    bw.write(sb.toString().toLowerCase());
    close();
  }
  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
