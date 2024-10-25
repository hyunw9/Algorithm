package PS.String;

import java.io.*;
import java.util.*;

public class boj_17609_회문 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    while (--n >= 0) {
        String line = br.readLine();
      System.out.println(check(line,0,line.length()-1,0));
    }
    close();
  }

  public static int check(String s,int l , int r,int cnt) {
// System.out.println(s);
    if(cnt >=2 ) return 2;
    
    while (l < r) {
      if (s.charAt(l) == s.charAt(r)) {
        // 한번씩 움직여서 보완할 수 있는지 보기
        r -= 1;
        l += 1;
      }else{
        return Math.min(check(s,l+1,r,cnt+1), check(s,l,r-1,cnt+1));
      }
    }
    // System.out.println(cnt);
    return cnt;
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
