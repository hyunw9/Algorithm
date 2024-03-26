package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_17413_단어뒤집기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    ArrayDeque<String> dq = new ArrayDeque<>();
    //태그가 존재시 <, > 나올때 까지 String Builder 로 추출해서 dq에 추가
    // 그 다음 없는 문자열 추출, 공백이 있다면 분리하고, 뒤집어서 Dq 에 넣기
    String line = br.readLine();

    int l = 0;
    int r = 0;

    for (int i = 0; i < line.length(); i++) {
      char now = line.charAt(i);
      if (now == '<') {
        int j = i;

        while (line.charAt(++j) != '>') {
        }
        String sub = line.substring(i, j + 1);
        dq.addLast(sub);
        i = j;

      } else {
        int j = i;
        while (++j < line.length() && line.charAt(j) != '<') {
        }
        String sub = line.substring(i, j);
        String[] arr = sub.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String v : arr) {
          StringBuilder tmp = new StringBuilder();
          tmp.append(v).reverse().append(" ");
          sb.append(tmp);
        }
        dq.addLast(sb.toString().trim());
        i = j - 1;
      }

    }
    for (String v : dq) {
      bw.write(v);
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
