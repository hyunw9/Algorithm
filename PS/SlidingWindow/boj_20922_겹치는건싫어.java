package PS.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_20922_겹치는건싫어 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static HashMap<Integer, Integer> map;
  private static int maxSize = Integer.MIN_VALUE;
  private static int[] arr;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    map = new HashMap<>();
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    for (int l = 0, r = 0; r < n; r++) {
      map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

      while (map.get(arr[r]) > k) {
        map.put(arr[l], map.get(arr[l]) - 1);
        l++;
      }
      maxSize = Math.max(maxSize, r - l + 1);
    }

    bw.write(maxSize + "");
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
