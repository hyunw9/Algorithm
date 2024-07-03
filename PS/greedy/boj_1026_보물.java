package PS.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1026_보물 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int[] arr= new int[n];
    int[] arr2=new int[n];
    int answer=0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0;i<n;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 0;i<n;i++){
      arr2[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    boolean[] used = new boolean[n];
    for(int i= 0;i<n;i++){
      int max = 0;
      int idx = 0;
      int l = 0;
      while(l<n){
        if(!used[l]){
          if(arr2[l]>max){
            max = arr2[l];
            idx = l;
          }
        }
        l++;
      }
      used[idx] = true;
      answer = answer + (max * arr[i]);
    }
    bw.write(answer+"");
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
