package PS.Tree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1967_트리의지름 {

  private static class Node{
    int next;
    int weight;

    public Node(int next, int weight) {
      this.next = next;
      this.weight = weight;
    }
  }

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static ArrayList<Node>[] arr;
  private static boolean[] isParent;
  private static boolean[] used;
  private static int ans;

  public static void main(String[] args) throws IOException {
    init();

    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    arr = new ArrayList[n+1];
    isParent=  new boolean[n+1];
    for(int i=  1; i <= n ; i++ ){
      arr[i] = new ArrayList<>();
    }
    for(int i = 0; i < n-1; i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[start].add(new Node(end,c));
      arr[end].add(new Node(start,c));
      isParent[start] = true;
    }
    for(int i = 1; i <=n ; i++ ){
      used = new boolean[n+1];
      dfs(i,0);

    }
    bw.write(ans+"");
    close();
  }

  public static void dfs(int node, int curr){
    if(!isParent[node] && curr !=0){
      ans = Math.max(curr,ans);
      return ;
    }
    used[node] = true;

    for(Node n : arr[node]){
      if(!used[n.next]){
        dfs(n.next,curr+n.weight);
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
