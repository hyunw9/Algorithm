package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;

public class boj_2170_선긋기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
//  private static class Line{
//    int start;
//    int end;
//    public Line(int start,int end){
//      this.start = start;
//      this.end = end;
//    }
//  }
  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    int cnt = 0;
    int[][] arr = new int[n][2];
    //Queue<Line> q = new LinkedList<>();
    for(int i = 0 ; i<n; i++){
      String line = br.readLine();
      int start = Integer.parseInt(line.split(" ")[0]);
      int end = Integer.parseInt(line.split(" ")[1]);
      arr[i][0]  = start;
      arr[i][1]  = end;
    }
    Arrays.sort(arr,(o1,o2)-> {
      if(o1[0]==o2[0]) {
        return o1[1] - o2[1];
      }
        return o1[0] - o2[0];
    });
    int cut = -1000000000;
    for(int[] now: arr){
      //System.out.println(cnt);
      if(now[0] >= cut ){ //안 겹치거나
        cut = now[1];
        cnt += now[1] - now[0];
      }else if( now[1] <= cut){ // 다 겹치거나
        continue;
      }else { //조금만 겹치거나 (삐죽 튀어나올 경우 )
        int tmp = cut;//4
        cut = Math.max(cut, now[1]);
        cnt += now[1] - tmp;
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
