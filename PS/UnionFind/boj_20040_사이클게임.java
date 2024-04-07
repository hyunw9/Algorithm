package PS.UnionFind;

import java.io.*;
import java.util.*;

public class boj_20040_사이클게임 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    arr= new int[n];
    for(int i = 0; i<n; i++){
        arr[i] = i;
    }
    int round = 0;
    for(int i = 0 ; i < m; i++){
        st=new StringTokenizer(br.readLine());
        int f = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        if(find(f)==find(s)){
            round = i+1;
            break;
        }else{
            union(f,s);
        }
    }
    bw.write(round+"");
    close();
  }

  public static int find(int x){
    if(arr[x] == x){
        return x;
    }
    return arr[x] = find(arr[x]);
  }

  public static void union(int a, int b){
    int pa = find(a);
    int pb = find(b);

    if(pa!=pb){
        if(pa<pb){
            arr[pb]=pa;
        }else{
            arr[pa]=pb;
        }
    }
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}
