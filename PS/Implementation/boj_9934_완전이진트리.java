package PS.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_9934_완전이진트리 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static StringBuilder[] ans ;
  private static int n;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
    arr = new int[(int) Math.pow(2,n)-1];
    ans = new StringBuilder[n];
    for(int i = 0; i < n ; i++){
      ans[i] = new StringBuilder();
    }
    st=  new StringTokenizer(br.readLine());
    for(int i = 0; i<arr.length ;i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }
    dfs(0,arr.length-1,0);
    for(StringBuilder sb : ans){
      System.out.println(sb.toString());
    }
    close();
  }

  public static void dfs(int left,int right,int depth) throws IOException {
    if(depth == n) {
      return;
    }
      int mid = (right + left) / 2;
      ans[depth].append(arr[mid]+" ");
      dfs(left,mid-1,depth+1);
      dfs(mid+1,right,depth+1);

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
