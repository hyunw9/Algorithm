package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_10971_외판원순회 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[][] arr;
  private static boolean[] used;
  private static int min = Integer.MAX_VALUE;
  private static int n ;
  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    n = Integer.parseInt(st.nextToken());
    arr = new int[n][n];
    used = new boolean[n];

    for(int i=0;i<n;i++){
      st= new StringTokenizer(br.readLine());
      for(int j = 0 ; j < n ; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    for(int i =0 ; i<n ; i++){
      used[i] = true;
      dfs(1,0,i,i);
      used[i] = false;
    }
    bw.write(min+"");
    close();
  }

  public static void dfs(int depth, int curr,int node,int start){
    if(depth ==n){
      if(checkVisit(used)){
        if(arr[node][start]!= 0){
          curr+=arr[node][start];
          min = Math.min(min,curr);

        }
      }
      return;
    }

    for(int i = 0 ; i < n ; i++){
      if(!used[i]&&arr[node][i]!=0){
        used[i] = true;
        dfs(depth+1,curr+arr[node][i],i,start);
        used[i] =false;
      }
    }

  }

  public static boolean checkVisit(boolean[] used){
    for(int i = 0; i < n ; i++){
      if(!used[i]) return false;
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
