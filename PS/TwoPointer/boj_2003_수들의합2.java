package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_2003_수들의합2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int []arr = new int[n];
    st= new StringTokenizer(br.readLine());
    for(int i = 0 ; i < n; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int ans = 0 ;
    int l = 0;
    int r = 0;
    int sum = arr[0];
    while( r<n){
      if(sum == m){
        ans++;
        //System.out.println("L: "+l + " R: "+ r);
        sum-=arr[l++];
      }else if(sum<m){
        if(r +1  < n){
          sum+=arr[++r];
        }else{
          break;
        }
      }else{
        sum-=arr[l++];
      }
    }
    bw.write(ans+"");
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
