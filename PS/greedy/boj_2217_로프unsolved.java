package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2217_로프unsolved {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int []arr = new int[n];
    int min = 987654321;

    for(int i = 0;i<n;i++){
      int wire = Integer.parseInt(br.readLine());
      arr[i] = n* wire;
      min = Math.min(min,arr[i]);
    }
    bw.write(min+"");
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
