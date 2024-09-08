package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_1459_걷기 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static class Loc {
    long y;
    long x;
    long c;

    public Loc(long y, long x,long c) {
      this.y = y;
      this.x = x;
      this.c = c;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    long dy = Integer.parseInt(st.nextToken());
    long dx = Integer.parseInt(st.nextToken());
    long costj = Integer.parseInt(st.nextToken());
    long costd = Integer.parseInt(st.nextToken());
    Loc now = new Loc(dy, dx, 0);
    long c1, c2, c3;
    c1 =( dy+dx)* costj;
    if((dy+dx)%2==0){
        c2 = Math.max(dy,dx) * costd;
    }else{
        c2 =( Math.max(dy,dx)-1 ) * costd + costj;
    }
    c3 = Math.min(dy,dx)*costd + (Math.abs(dy-dx))*costj;

    
    
    
    System.out.println(Math.min(c1,Math.min(c2,c3)));
    close();
  }

  private static void init() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  private static void close() throws IOException {
    br.close();
    bw.close();
  }
}

/*
 ** 간략한 풀이 :
 */
