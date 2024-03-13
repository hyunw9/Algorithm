package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_16401_과자나눠주기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    int  n= Integer.parseInt(st.nextToken());
    int [] arr= new int[n];
    st= new StringTokenizer(br.readLine());
    for(int i = 0 ; i < n ; i ++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int l = 1 ;
    int r = arr[n-1];

    while(l<=r){

      int mid = (l+r)/2;
      int cnt = 0;
      for(int j = 0; j<n;j++){
        if(mid ==0) break;
        cnt+= arr[j]/mid;
      }

      if(cnt<m){
        r =mid -1;
      }else{
        l = mid +1;
      }
    }
    if(r == -1){
      bw.write(0+"");
    }else{
      bw.write(r+"");
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
