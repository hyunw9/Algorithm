package PS.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class boj_12891_DNA비밀번호 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static HashMap<Character, Integer> map;

  private static char[] chr = {'A', 'C', 'G', 'T'};

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    map = new HashMap<>();
    int s = Integer.parseInt(st.nextToken());
    int p = Integer.parseInt(st.nextToken());
    String line = br.readLine();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < 4; i++) {
      int num = Integer.parseInt(st.nextToken());
      if (num != 0) {
        map.put(chr[i], num);
      }
    }
    int ans = 0;
    int win = 0;
    for (int r=0,l=0; r < s; r++) {
      win = r - l + 1;

      if (map.containsKey(line.charAt(r))) {
        map.put(line.charAt(r), map.get(line.charAt(r)) - 1);
      }
      if (win == p) {
        if (check(map)) {
          ans++;
        }
        if (map.containsKey(line.charAt(l))) {
          map.put(line.charAt(l), map.get(line.charAt(l)) + 1);
        }
        l++;
      }
    }
    bw.write(ans + "");
    close();
  }

  public static boolean check(HashMap<Character, Integer> map) {
    for(char c : new char[]{'A','C','G','T'}){
      if(map.containsKey(c) && map.get(c)>0) return false;
    }
    return true;
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
