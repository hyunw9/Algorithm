package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_16924_십자가찾2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int n;
  private static int m;

  public static void main(String[] args) throws IOException {
    init();
    String line = br.readLine();
    n = Integer.parseInt(line.split(" ")[0]);
    m = Integer.parseInt(line.split(" ")[1]);
    int[][] map = new int[n][m];
    boolean[][] used = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      line = br.readLine();
      for (int j = 0; j < m; j++) {
        if (line.charAt(j) == '*') {
          map[i][j] = 1;
          used[i][j] = true;
        } else {
          map[i][j] = 0;
        }
      }
    }
    //System.out.println(find(map,2,4));

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == 1) {
          int size = find(used,map,i,j);
          if(size == 0) continue;

//

        }
      }
    }
    for(int i = 0 ; i < n; i++){
      for(int j = 0 ; j < m ;j++){
        if(used[i][j]) {
          System.out.println(-1);
          return;
        }
      }
    }
    close();
  }

  public static int find(boolean[][] used, int[][] map, int y, int x) throws IOException {
    int size = 1;
    while (x - size >= 0 && x + size < m && y - size >= 0 && y + size < n) {
        if (map[y][x + size] == 1 && map[y][x - size] == 1 && map[y + size][x] == 1 && map[y - size][x] == 1) {
          bw.write((y+1)+" "+(x+1)+" "+ size+"\n");
          size++;
        }else{
          break;
        }

    }
    size--;
    if(size>0){
      int cnt = 0 ;
      while(cnt<=size){
        used[y][x+cnt]=false;
        used[y][x-cnt]=false;
        used[y+cnt][x]=false;
        used[y-cnt][x]=false;
        cnt++;
      }
    }

    return size;
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
