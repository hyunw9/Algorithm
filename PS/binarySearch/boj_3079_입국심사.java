package PS.binarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3079_입국심사 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    //28 안에 6명이 가능한가 ?
    //정렬한다음에, 7 로 나누면 4 , 10으로 나누면 2 ; 그럼 6 가능 .
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    long max = 0;
    int[] arr =new int[n];

    for(int i = 0; i < n ; i++){
      arr[i] = Integer.parseInt(br.readLine());
      max= Math.max(max,arr[i]);
    }
//    Arrays.sort(arr);

    long l = 0;
    long h = m*max;

    while(l<=h){
      long mid = (l+h)/2;

      long cnt = 0 ;
      for(int i = 0 ; i < n ; i++){
        if(cnt >=m) break;
        cnt += mid/arr[i];
      }

      if(cnt>=m){ //cnt 가 미드보다 크다, 절반보다 개수가 크다.
        h = mid -1;
      }else{
        l = mid+1;
      }

    }
    bw.write(l+"");
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
