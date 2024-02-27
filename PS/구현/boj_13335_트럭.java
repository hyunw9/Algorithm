package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_13335_트럭 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());
    int time = 0;
    int weight = 0;
    int[] trucks = new int[n];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      trucks[i] = Integer.parseInt(st.nextToken());
    }
    Queue<Integer> bridge = new LinkedList<>();
    for (int truck : trucks) {

      while (true) {
//        System.out.println(truck);
//        System.out.println("time : " + time);
        if (bridge.isEmpty()) {
          bridge.add(truck);
          weight += truck;
          time++;
          break;
        } else {
          //큐가 안비었는데, 다리가 안 차서 트럭이 올라올 수 있는 경우,
          if (bridge.size() == l) {
            weight -= bridge.poll();
          } else if (weight + truck <= w) {
            weight += truck;
            bridge.add(truck);
            time++;
            break;
          } else {
            bridge.add(0);
            time += 1;
          }
          //다리가 꽉 찬 경우
          //무게 떄문에 트럭이 올라올 수 없는 경우,
          //
        }
      }
    }
    bw.write((time + l) + "");
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
