package PS.구현;

import com.sun.jdi.connect.Connector;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_1769_3의배수 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
      int number = 0;
      int num = 0;
      int cnt = 0;
      while (true) {
        int len = line.length();
        if(len == 1) {
          number = Integer.parseInt(line);
          break;
        }
        num = 0;
        for (int i = 0; i < line.length(); i++) {
          char ch = line.charAt(i);
          num += Integer.parseInt(String.valueOf(ch));
        }
        line = num + "";
        number = num;
        cnt++;

      }
      bw.write(cnt + "\n");

      if (number % 3 == 0) {
        bw.write("YES");
      } else {
        bw.write("NO");
      }

    close();
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }



}
