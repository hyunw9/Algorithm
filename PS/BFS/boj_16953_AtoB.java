package PS.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16953_AtoB {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static Queue<int[]> q;

  public static void main(String[] args) throws IOException {
    init();
    q = new LinkedList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    HashMap<Integer, Boolean> map = new HashMap<>();

    int start = Integer.parseInt(st.nextToken());
    int end = Integer.parseInt(st.nextToken());
    int ans = 0;
    int plus1 = Integer.parseInt(start + "1");
    int multi = end * 2;
    q.add(new int[]{plus1, 0});
    q.add(new int[]{multi, 0});

    while(end!=start){
      if(end<start){
        ans = -2;
        break;
      }

      if(end % 2 == 0){
        end = end/2;
        ans++;
      }else if(end % 10 == 1){
        end = end/10;
        ans++;
      }
      else{
        ans = -2;
        break;
      }
    }
    bw.write(ans+1+"");
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
