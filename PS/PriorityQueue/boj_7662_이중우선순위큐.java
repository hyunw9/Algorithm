package PS.PriorityQueue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_7662_이중우선순위큐 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc = Integer.parseInt(st.nextToken());
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < tc; i++) {
      int maxVal = 0;
      int minVal = 0;
      st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
      for (int j = 0; j < t; j++) {

        st = new StringTokenizer(br.readLine());
        String ops = st.nextToken();
        int num = Integer.parseInt(st.nextToken());
        if (ops.equals("I")) {
          map.put(num, map.getOrDefault(map.get(num), 0) + 1);
          minHeap.add(num);
          maxHeap.add(num);
//          System.out.println("minHeap에 값 넣음 = " + minHeap);
//          System.out.println("maxHeap에 값 넣음 = " + maxHeap);
//          System.out.println("-----------------------------");

        } else if(ops.equals("D")){
          if(num == 1){
            while(!maxHeap.isEmpty()){
              int top = maxHeap.poll();
              if (map.get(top) > 1){
                map.put(top, map.get(top) - 1);
              } else {
                map.remove(top);
                break;
              }
            }
          } else if(num == -1){
            while(!minHeap.isEmpty()){
              int top = minHeap.poll();
              if (map.get(top) > 1){
                map.put(top, map.get(top) - 1);
              } else {
                map.remove(top);
                break;
              }
            }
          }
        }

        if(minHeap.isEmpty()|| maxHeap.isEmpty()){
          bw.write("EMPTY\n");
        }else{

          // maxHeap에서 값이 map에 존재할 때까지 poll
          while(!maxHeap.isEmpty()){
            maxVal = maxHeap.poll();
            if(map.containsKey(maxVal) && map.get(maxVal) > 0){
              break;
            }
          }
          // minHeap에서 값이 map에 존재할 때까지 poll
          while(!minHeap.isEmpty()){
            minVal = minHeap.poll();
            if(map.containsKey(minVal) && map.get(minVal) > 0){
              break;
            }
          }
        }
      }
      bw.write(maxVal + " " + minVal);

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
