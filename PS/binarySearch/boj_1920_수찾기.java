package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920_수찾기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static int n;
  private static int m;
  private static int[]a;
  private static int[]num;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    a = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      a[i] = Integer.parseInt(st.nextToken());
    }
    st= new StringTokenizer(br.readLine());
    m = Integer.parseInt(st.nextToken());
    num = new int[m];
    st= new StringTokenizer(br.readLine());
    for (int i = 0; i <m ; i++) {
      num[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(a);

    int idx = 0;

    while(idx< m) {
      int low = 0;
      int high = n-1;
      boolean flag = false;
      while (low <= high) {
        int mid = (low + high) / 2;

        if (a[mid] == num[idx]) {
          flag = true;
          break;
        }

        if (a[mid] > num[idx]) {
          high = mid - 1;
          //low = low +1;
        } else if (a[mid] <= num[idx]) {
          low = mid + 1;
        }
      }
      if(flag){
        bw.write(1+"\n");
      }else{
        bw.write(0+"\n");
      }
      idx++;
    }
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
