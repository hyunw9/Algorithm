package PS.Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class boj_10972_다음순열 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[] arr = new int[n];
    st = new StringTokenizer(br.readLine());
    for(int i = 0 ; i < n ; i ++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    if(next_permutation(n, arr)){
      for(int val : arr){
        bw.write(val+" ");
      }
    }else{
      bw.write(-1+"");
    }
    //i 보다 큰거 찾기

//    스왑
    close();
  }

  private static boolean next_permutation(int n, int[] arr) throws IOException {
    int i = n -1;
    while(i>0 && arr[i]< arr[i-1]){
      i--;
    }
    if(i<=0) return false;
    //끝에서부터 i < i +1 인거 찾기
    if(i>0) {
      int j = n - 1;
      while (j > i && arr[i - 1] > arr[j]) {
        j--;
      }

      int temp = arr[i - 1];
      arr[i - 1] = arr[j];
      arr[j] = temp;

      while (i < j) {
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    return true;
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
