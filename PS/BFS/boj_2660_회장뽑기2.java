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

public class boj_2660_회장뽑기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] rank;
  private static int[] result;
  private static ArrayList<Integer>[] arr;
  private static int[][] map;
  private static int n;

  public static void main(String[] args) throws IOException {
    init();
    n = Integer.parseInt(br.readLine());
    arr = new ArrayList[n + 1];
    map = new int[n][n];
    rank = new int[n + 1];
    result = new int[n];
    for (int i = 1; i <= n; i++) {
      arr[i] = new ArrayList<>();
    }
    for(int i= 0 ; i <n; i++){
      for(int j = 0; j<n ; j ++){
        if(i!=j){
          map[i][j] = 987654321; //Integer.MAX_VALUE XXXXX
        }
      }
    }

    while(true) {
        String line = br.readLine();
        int from = Integer.parseInt(line.split(" ")[0]);
        int to = Integer.parseInt(line.split(" ")[1]);
        if(from == -1 && to == -1) break;

        arr[from].add(to);
        arr[to].add(from);
        map[from-1][to-1] = 1;
        map[to-1][from-1] = 1;
      //System.out.println(Arrays.deepToString(map));

    }

    bfs();
    floyd();
    System.out.println("rank: "+ Arrays.toString(rank));
    System.out.println("result : "+ Arrays.toString(result));
    System.out.println(Arrays.deepToString(map));
    close();
  }

  public static void bfs() {
    Queue<Friend> q = new LinkedList<>();

    for (int i = 1; i <= n; i++) {
      boolean[] used = new boolean[n + 1];
      if (rank[i] == 0) {
        q.add(new Friend(i, 0));


      }
      int maxRank = 0;
      while (!q.isEmpty()) {

        Friend now = q.poll(); // 1 2 3 4 5  //1 번 회원이 2, 3, 4    5 -> 2
        maxRank = now.rank;
        for (int a : arr[now.me]) {
          if (!used[a]) {
            used[a] = true;
            q.add(new Friend(a, now.rank + 1));
            maxRank = Math.max(maxRank, now.rank + 1);
          }
        }
      }
      rank[i] = maxRank;
    }
  }

  public static void floyd() {

    for(int k = 0; k<n;k++){
      for(int i =0; i< n ; i++){
        for(int j = 0; j< n; j++){
          if(map[i][k] + map[k][j] < map[i][j]){
            map[i][j] = map[i][k]+ map[k][j];
          }
        }
      }
    }

    for(int i = 0;i<n;i++){
      int max = 0;
      for(int j =0 ; j < n; j++){
        if(map[i][j]>max){
          max = map[i][j];
        }
      }
      result[i] = max;
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

  private static class Friend {

    int me;
    int rank;

    public Friend(int me, int rank) {
      this.me = me;
      this.rank = rank;
    }
  }
}
