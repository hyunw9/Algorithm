package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_11047_동전0 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());
    int cnt =0;
    int[] arr = new int[n];
    for(int i = 0; i<arr.length;i++){
      st= new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }
    //
    while(target>0){
      int max = 0;
      for(int i = 0 ; i < arr.length;i++){
        if(arr[i]<=target && arr[i]>max){
          max = arr[i];
        }
      }
      cnt = cnt + (target/max);
      target = target%max;
    }
    bw.write(cnt+"");
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
