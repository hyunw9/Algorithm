package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class boj_2302_극장좌석 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n+1];
    int t = Integer.parseInt(br.readLine());
    int[] vip = new int[t];
    for(int i = 0;i<t;i++){
      vip[i]= Integer.parseInt(br.readLine());
    }
    arr[0] =1;
    arr[1] = 1;
    for(int i = 2; i<=n; i++){
      arr[i] = arr[i-1]+ arr[i-2];
    }

    int pre =0;
    int cnt= 1;
    for(int i =0;i<vip.length; i++){
      cnt *= arr[vip[i]-pre-1];
      pre = vip[i];
    }
    cnt*=arr[n-pre];
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
