package PS.UnionFind;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class boj_1647_도시분할계획 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static int[] cost;
  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    int n = Integer.parseInt(line.split(" ")[0]);
    int m = Integer.parseInt(line.split(" ")[1]);
    arr= new int[n+1];
    for(int i = 1; i <=n ; i++){
      arr[i]= i;
    }
    cost = new int[n+1];
    PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->{
      if(o1[2]==o2[2]) return o1[0]-o2[0];
      return o1[2]-o2[2];
    });
    for(int i = 0 ; i < m; i++){
      int[] r = new int[3];
      String now = br.readLine();
      r[0] = Integer.parseInt(now.split(" ")[0]);
      r[1]  = Integer.parseInt(now.split(" ")[1]);
      r[2] = Integer.parseInt(now.split(" ")[2]);
      pq.add(r);
    }
    int sum =0;
    int max = 0;
    while(!pq.isEmpty()){
      int[] now = pq.poll();
      if(find(now[0])!=find(now[1])){
        union(now[0],now[1]);
        cost[now[1]] = now[2];
        sum+=cost[now[1]];
        max = Math.max(max,cost[now[1]]);
      }
    }

    bw.write(sum-max+"");
    close();
  }
  public static boolean isDone(int[] arr){
    for(int i = 2; i <=arr.length; i++){
      if(arr[i]!=1) return false;
    }
    return true;
  }
  public static int find(int x){
    if(arr[x] == x){
      return x;
    }
    return arr[x] = find(arr[x]);
  }
  public static void union(int a, int b){
    arr[find(b)] =find(a);
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
