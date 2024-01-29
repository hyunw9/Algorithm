package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2457_공주님의정원 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    Flower[] arr = new Flower[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = 100 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
      int end = 100 * Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
      arr[i] = new Flower(start, end);
    }
    Arrays.sort(arr, (o1, o2) -> {
      if (o1.start == o2.start) {
        return o2.end - o1.end;
      }
      return o1.start - o2.start;
    });
    //    for(int i = 0 ; i < n;i++){
    //      System.out.println("start: "+  arr[i].start + " end:  "+arr[i].end);
    //    }
    int start = 301;
    int end = 1201;
    int idx = 0;
    int cnt = 0;
    int max = 0;
    while (start < end) {
      boolean flag = false;


      for (Flower now : arr) {
        if (now.start > start) {
          break;
        }
        if (now.end > max) {
          max = now.end;
          //          System.out.println("now.start: " + now.start + " now.end : " + now.end);
          flag = true;
        }
      }
      if (flag) {
        cnt++;
        start = max;
      }else{
        break;
      }
    }
    if (max<end) {
      bw.write(0+"");
    }else{
      bw.write(cnt+"");
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

  private static class Flower {

    int start;
    int end;

    public Flower(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

}
