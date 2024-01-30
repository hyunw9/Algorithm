package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class boj_15686_치킨배달 {

  private static class Node{
    int y;
    int x;
    public Node(int y, int x){
      this.y= y;
      this.x=x;
    }
  }

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int min = Integer.MAX_VALUE;
  private static int n;
  private static int m;
  private static LinkedList<Node> store;
  private static LinkedList<Node> home;
  private static boolean[] opened;



  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    store = new LinkedList<>();
    home = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= n; j++) {
        int now =Integer.parseInt(st.nextToken());
        if (now == 2) {
          store.add(new Node(i,j));
        }else if(now==1){
          home.add(new Node(i,j));
        }
      }
    }
    opened = new boolean[store.size()];
    dfs(0,0);
    bw.write(min + "");
    close();
  }

  public static void dfs(int depth, int cnt){
    if(cnt == m){
      int num = 0;

      for(int i = 0; i<home.size();i++){
        int temp = Integer.MAX_VALUE;

        for(int j = 0;j<store.size();j++){
          if(opened[j]){
            temp = Math.min(Math.abs(home.get(i).y-store.get(j).y)+Math.abs(home.get(i).x-store.get(j).x),temp);
          }
        }
        num+= temp;
      }
      min = Math.min(min,num);
      return;
    }
    for(int i =depth; i<opened.length;i++){
      opened[i] = true;
      dfs(i+1,cnt+1);
      opened[i] =false;
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
