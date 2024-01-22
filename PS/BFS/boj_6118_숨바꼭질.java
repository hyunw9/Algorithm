package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6118_숨바꼭질 {


  private static Queue<Integer> q;
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[] used;
  private static int[] cost;
  private static ArrayList<Integer>[] arr;


  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int e = Integer.parseInt(st.nextToken());
    q = new LinkedList<>();
     arr = new ArrayList[n+1];
     used = new boolean[n+1];
     cost = new int[n+1];
     for(int i =1;i<=n;i++){
       arr[i]= new ArrayList<>();
     }

     for(int i = 0 ; i <e; i++){
       st= new StringTokenizer(br.readLine());
       int start = Integer.parseInt(st.nextToken());
       int end = Integer.parseInt(st.nextToken());
       arr[start].add(end);
       arr[end].add(start);
     }
    for(int a :arr[1]){
      used[1] = true;
      if(!used[a]){
        used[a] = true;
        cost[a] = cost[1]+1;
        q.add(a);
      }
    }

    while(!q.isEmpty()){
      int now = q.poll();
      for(int next :arr[now]){
        if(!used[next]){
          used[next] = true;
          cost[next] = cost[now]+1;
          q.add(next);
        }
      }
    }

    int max = 0;
    ArrayList<Integer> ans = new ArrayList<>();
    for(int i = 0; i<cost.length; i++){
      max = Math.max(max,cost[i]);
    }
    for(int i = 0; i<cost.length; i++){
      if(cost[i]==max){
        ans.add(i);
      }
    }
    Collections.sort(ans);
    bw.write(ans.get(0)+" "+max+ " "+ ans.size());

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
