package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_22862_가장긴짝수연속한부분수열 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int s = Integer.parseInt(st.nextToken());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[s];
    st= new StringTokenizer(br.readLine());
    for(int i= 0; i<s;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    //Arrays.sort(arr);
    int max = 0;
    int skip = n;
    int cnt =0;

    int l =0;
    int r = 0;
    while(true){
      if(cnt>n){
        if(arr[l]%2==1){
          cnt-=1;
        }
        l++;
      }else if(r== s){
        break;
      }else{
        if(arr[r]%2==1){
          cnt+=1;
        }
        r+=1;
      }
      if(cnt<=n){
        max= Math.max(max,r-l-cnt);
      }
    }

    bw.write(max+"");
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
