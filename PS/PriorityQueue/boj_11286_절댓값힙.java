package PS.PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class boj_11286_절댓값힙 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
      if(Math.abs(o1)==Math.abs(o2)){
        return o1-o2;
      }
      return Math.abs(o1)-Math.abs(o2);
    });
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int next =Integer.parseInt(br.readLine());
      if(next == 0){
        if(pq.isEmpty()){
          bw.write("0\n");
        }else{
          bw.write(pq.poll()+"\n");
        }
      }else{
        pq.add(next);
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
