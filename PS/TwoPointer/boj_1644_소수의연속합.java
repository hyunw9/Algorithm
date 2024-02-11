package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class boj_1644_소수의연속합 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();

    //에라토스테네스 체
    //소수 배열 생성
    //투포인터로 가능한지 판별
    int n = Integer.parseInt(br.readLine());
    boolean[] map = new boolean[n+1];
    if(n ==1 ){
      bw.write(0+"");
      close();
      System.exit(0);
    }
    map[1] = true;
    for(int i = 2; i <= Math.sqrt(n); i++){
      for(int j = i*i ; j<=n; j+=i) map[j] = true;
    }
    int size = 0;
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 2; i<map.length;i++){
      if(!map[i]){
        list.add(i);
      }
    }
    int[] arr = new int[list.size()];
    for(int i = 0 ; i < list.size(); i++){
      arr[i] = list.get(i);
    }
    int l = 0;
    int r = 0;
    int sum = arr[0];
    int cnt = 0;
    while(r<arr.length){
      if(sum == n){
        cnt++;
        sum -= arr[l++];
      }else if(sum<n){
        if(r+1 < arr.length){
          sum+=arr[++r];
        }else{
          break;
        }
      }else{
        sum-=arr[l++];
      }
    }

    //System.out.println(list);
    bw.write(cnt+"");
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
