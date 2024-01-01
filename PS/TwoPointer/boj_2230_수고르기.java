package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2230_수고르기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int min=Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    for(int i = 0; i<n;i++){
      int num = Integer.parseInt(br.readLine());
      arr[i]= num;
    }
    Arrays.sort(arr);
    int l =0;
    int r = 1;
    while(l<n&&r<n){
      int val = Math.abs(arr[r]- arr[l]);
      if(val >= m){
        min = Math.min(min,val);
        l++;
      }
      else if(val< m){
        r++;
      }

    }
    bw.write(min+"");

    close();
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
