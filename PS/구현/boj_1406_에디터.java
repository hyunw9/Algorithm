package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class boj_1406_에디터 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static List<String> arr;
  private static int idx;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    arr = new LinkedList<>();
    int times = Integer.parseInt(br.readLine());

    for (int i = 0; i < line.length(); i++) {
      arr.add(String.valueOf(line.charAt(i)));
    }
    idx = line.length();
    ListIterator<String> iter = arr.listIterator(idx);

    for (int i = 0; i < times; i++) {


      String now = br.readLine();
      String cmd = now.split(" ")[0];

      if (cmd.equals("P")) {
        String offset = String.valueOf(now.charAt(2));
          iter.add(offset);
      } else if (cmd.equals("L")) {
        if (iter.hasPrevious()) {
          iter.previous();
        }
      } else if (cmd.equals("D")) {
        if (iter.hasNext()) {
          iter.next();
        }
      } else if (cmd.equals("B")) {
        if (iter.hasPrevious()) {
          iter.previous();
          iter.remove();
        }

      }
    }
    for (String s : arr) {
      bw.write(s);
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
