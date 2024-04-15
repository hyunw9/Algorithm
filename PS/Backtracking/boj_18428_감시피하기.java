package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj_18428_감시피하기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static String[][] map;
  private static List<Node> students;
  private static int n;
  private static int[] dx = {0,0,-1,1};
  private static int[] dy = {-1,1,0,0};

  private static class Node{
    int y;
    int x;

    public Node(int y, int x) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    map = new String[n][n];
    students = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        map[i][j] = st.nextToken();
        if(map[i][j].equals("S")){
          students.add(new Node(i,j));
        }
      }

    }
    dfs(0);
    bw.write("NO");
    close();
  }

  private static void dfs(int cnt) throws IOException {
    if(cnt==3){
      bfs();
      return;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if(map[i][j].equals("X")){
          map[i][j] = "O";
          dfs(cnt+1);
          map[i][j] = "X";
        }
      }
    }
  }

  private static void bfs() throws IOException {
    ArrayDeque<Node> teachers = new ArrayDeque<>();
    String[][] copyMap = new String[n][n];
    boolean[][] check = new boolean[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        copyMap[i][j] = map[i][j];
        if(copyMap[i][j].equals("T")){
          teachers.addFirst(new Node(i,j));
          check[i][j] = true;
        }
      }
    }

    while(!teachers.isEmpty()){
      Node now = teachers.pollLast();
      int x = now.x;
      int y = now.y;

      for (int i = 0; i < 4; i++) {
        int nx = dx[i] + x;
        int ny = dy[i] + y;

        while(nx>=0 && ny >= 0 && nx<n && ny <n){
          if(!copyMap[ny][nx].equals("O")){
            check[ny][nx] = true;
            nx += dx[i];
            ny += dy[i];
          }else{
            break;
          }
        }
      }
    }

    if(checkValidate(check)){
      bw.write("YES");
      close();
      System.exit(0);
    }
  }
  public static boolean checkValidate(boolean[][] check){
    for (Node student : students) {
      if(check[student.y][student.x])
        return false;
    }
    return true;
  }

  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }
}
