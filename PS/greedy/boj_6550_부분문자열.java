package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_6550_부분문자열 {

  private static BufferedReader br;
  private static BufferedWriter bw;


  public static void main(String[] args) throws IOException {
    init();
    String input ="";
    while((input=br.readLine())!=null) {
      String f = input.split(" ")[0];
      String s = input.split(" ")[1];
      int count = 0;
      int offset = 0;
      for (int i = 0; i < f.length(); i++) {
        char now = f.charAt(i);

        for (int j = offset; j < s.length(); j++) {
          if (now == s.charAt(j)) {
            count++;
            offset = j + 1;
            break;
          }
        }
      }
      if (count != f.length())
        bw.write("NO");
      else
        bw.write("YES");
    }
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
