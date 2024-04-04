package PS.PriorityQueue;

import java.io.*;
import java.util.*;

public class boj_11279_최대힙 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    int n = Integer.parseInt(br.readLine());
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->o2-o1);

    while(--n>=0){
      int now =Integer.parseInt(br.readLine());

      if(now == 0){
        if(pq.isEmpty()){
          bw.write("0\n");
        }else{
          bw.write(pq.poll()+"\n");
        }
      }else{
        pq.add(now);
      }
    }
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
