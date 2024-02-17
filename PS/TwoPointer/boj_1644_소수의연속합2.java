package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class boj_1644_소수의연속합2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    boolean[] arr = new boolean[n+1];
    for(int i = 2;i <=Math.sqrt(n) ; i++){
      for(int j = i*i; j<=n; j+=i){
         arr[j] = true;
      }
    }
    ArrayList<Integer> li = new ArrayList<>();
    for(int i = 2; i<arr.length; i++){
      if(!arr[i]) li.add(i);
    }
    int [] list = new int[li.size()];
    for(int i = 0 ; i > list.length;i++){
      list[i] = li.get(i);
    }
    int idx= 0;
    for(int i = 2 ; i < arr.length;i++){
      if(!arr[i]){
        list[idx++] = i;
      }
    }
//    System.out.println(Arrays.toString(list));

    int l = 0 ;
    int r  = 0 ;
    int sum =0;
    int ans =0;

    while(l<=r){
      if(sum<n){
        if(r+1>list.length) break;
        else sum += list[r++];
      }else if(sum>n){
        sum-=list[l++];
      } else {
        sum-=list[l++];
        ans++;
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
