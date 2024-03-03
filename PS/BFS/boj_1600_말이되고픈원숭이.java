package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_1600_말이되고픈원숭이 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static boolean[][] used;
  private static int[][] map;
  private static int n;
  private static int m;
  private static int k;
  private static int min = 987654321;
  private static Queue<Node> q ;

  public static class Node{
    int y;
    int x;
    int c;
    public Node(int y,int x ,int c){
      this.y=y;
      this.x=x;
      this.c=c;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st= new StringTokenizer(br.readLine());
    int k = Integer.parseInt(st.nextToken());
    st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for(int i = 0 ; i <n; i++){
      st= new StringTokenizer(br.readLine());

      for(int j = 0 ; j < m; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    used= new boolean[n][m];
    used[0][0] = true;

    q =new LinkedList<>();
    q.add(new Node(0,0,0));



    close();
  }

  public void bfs(){

    //사방이 장애물인 경우, 말점프 해야됨
    //그렇지 않은 경우도, 말점프를 최대한 사용하는 것이 빠름

    //일반 사방으로 이동하는데, 그 부분이 막혀있다면 말점프 해보기 ?
    //그래서 말점프 한 횟수가 k 보다 작거나 같은 경우만 값으로 갱신하기 .

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
