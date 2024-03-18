package PS.SlidingWindow;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1806_부분합 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    int[] arr= new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < n ; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int l=0;
    int r=0;
    int sum=arr[0];
    int min = 100000000;
    while(l<=r && r<n){
      int window = r-l +1;

      if(sum >=m){
        sum-= arr[l];
        l++;
        min = Math.min(min,window);
      }else{
        if(r+1 < n) {
          r++;
          sum += arr[r];
        }else{
          r++;
        }
      }
    }
    if(min == 100000000){
      bw.write("0");
    }else{
      bw.write(min+"");
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
