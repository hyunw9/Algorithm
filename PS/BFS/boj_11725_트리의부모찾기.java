package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_11725_트리의부모찾기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] arr;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    used = new boolean[n+1];
    arr= new int[n+1];
    Queue<Integer>q = new LinkedList<>();
    ArrayList<Integer>[] l = new ArrayList[n+1];
    for(int i = 1 ; i<=n; i++){
      l[i] = new ArrayList<>();
    }

    for (int i = 1; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int first = Integer.parseInt(st.nextToken());
      int second = Integer.parseInt(st.nextToken());
      l[first].add(second);
      l[second].add(first);
    }
    used[1] = true;
    q.add(1);

    while(!q.isEmpty()){
      int now = q.poll();

      for(int a : l[now]){
        if(!used[a]){
          used[a] = true;
          arr[a]= now;
          q.add(a);
        }
      }

    }

    for(int i = 2; i <=n; i++){
      bw.write(arr[i]+"\n");
    }
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
