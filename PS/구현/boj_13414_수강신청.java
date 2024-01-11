package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class boj_13414_수강신청 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashSet<String> set = new LinkedHashSet<>();
    int k = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int next = 0;
    for (int i = 0; i < l; i++) {
      st = new StringTokenizer(br.readLine());
      String now = st.nextToken();
      if(set.contains(now)) set.remove(now);
      set.add(now);
    }
    int idx = 0;
    for (String s : set) {
      if(idx == k) break;
      bw.write(s+"\n");
      idx++;
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
