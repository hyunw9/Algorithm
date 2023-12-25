package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_16974_레벨햄버거 {

  private static BufferedReader br ;
  private static BufferedWriter bw;

  private static long[] total;
  private static long[] meat;

  public static void main(String[] args) throws IOException {
   init();
   StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken()); //재료 수
    long x = Long.parseLong(st.nextToken()); //총 패티 수

     total = new long[n+1];
     meat = new long[n+1];
    total[0]= 1;
    meat[0] = 1;

    for (int i = 1; i < n+1; i++) {
      total[i] = (total[i-1] * 2) + 3; //번 패티 번
      meat[i] = meat[i-1] * 2 + 1;
    }
    bw.write(getMeat(n,x)+"");
    close();


  }

  public static long getMeat(int n,long x){
    if(n == 0){
      if ( x == 0){
        return 0;
      }
      if(x==1){
        return 1;
      }
    }
    if(x == 1){
      return 0;
    } else if( x <= total[n-1]+1){
      return getMeat(n-1,x-1);
    }else if( x == total[n-1]+1 +1){
      return meat[n-1]+1;
    }else if(x <= 1+ total[n-1]+1 +total[n-1]){
      return meat[n-1] + 1 + getMeat(n-1,x- (1+ total[n-1]+ 1));
    }else{
      return meat[n-1] + meat[n-1];
    }
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
