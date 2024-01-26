package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1931_회의실배정3 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int[][]rooms = new int[n][2];
    for(int i = 0;i<n;i++){
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      rooms[i][0] = start;
      rooms[i][1] = end;
    }
    Arrays.sort(rooms,(o1,o2)->{
      if(o1[1]==o2[1]){
        return o1[0]-o2[0];
      }
      return o1[1]-o2[1];
    });
    int cnt = 0 ;
    int cut = 0;
    for(int i = 0;i<n;i++){

      if(rooms[i][0]>=cut){
        cut = rooms[i][1];
        cnt++;
      }
    }
    bw.write(cnt+"");
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
