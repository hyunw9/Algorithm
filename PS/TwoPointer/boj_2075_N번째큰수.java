package PS.TwoPointer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2075_N번째큰수 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    for(int i = 0; i < n; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0 ; j < n;j++){
        pq.add(Integer.parseInt(st.nextToken()));
      }
    }
    int cnt = 0;
    while(!pq.isEmpty()){
      cnt++;
      int now = pq.poll();

      if(cnt== n) {
        bw.write(now+"");
        break;
      }
    }

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
