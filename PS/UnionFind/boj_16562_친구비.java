package PS.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class boj_16562_친구비 {

  //적은 비용을 친구로 받아들여야 함 .
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr ;
  private static HashMap<Integer,Integer> map;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    map = new HashMap<>();
    int n = Integer.parseInt(st.nextToken());
    int  m = Integer.parseInt(st.nextToken());
    int minCost = Integer.parseInt(st.nextToken());
    int ans = 0;
    arr= new int[n+1];
    for(int i = 1; i <= n ; i ++){
      arr[i] = i;
    }
    st = new StringTokenizer(br.readLine());
    for(int i = 1 ;  i<=n; i++){
      map.put(i,Integer.parseInt(st.nextToken()));
    }
    for(int i = 0 ; i < m; i++){
      st= new StringTokenizer(br.readLine());
      int f = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
        union(f,s);

    }
//    Set<Integer> set = new HashSet<>(); 이 부분이 문제,
    //부모의 경우만 값을 추가해주면 된다. 문제 이해도가 틀린 이유
    for(int i = 1 ; i <=n ; i++){
      if(arr[i]==i){
        ans +=map.get(i);
      }
    }

    if(ans <= minCost){
      bw.write(ans+"");
    }else{
      bw.write("Oh no");
    }
//    System.out.println(Arrays.toString(arr));
//    System.out.println("minCost: "+ minCost+ " ans: "+ ans);
    close();
  }

  public static int find(int x){
    if(arr[x]==x)
      return x;
    return arr[x] = find(arr[x]);
  }

  public static void union(int a, int b){
    int fa = find(a);
    int fb = find(b);

    if(fa!=fb){
      int ca = map.get(fa);
      int cb = map.get(fb);

      if(ca>cb){
        arr[fa]=fb;
      }else{
        arr[fb]=fa ;
      }
    }

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
