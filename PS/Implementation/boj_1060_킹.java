package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_1060_킹 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static HashMap<String, int[]> map;
  private static String[] command = {"R", "L", "B", "T", "RT", "LT", "RB", "LB"};
  private static int[] dx = {1, -1, 0, 0, 1, -1, 1, -1};
  private static int[] dy = {0, 0, -1, 1, 1, 1, -1, -1};

  private static class Node {

    char y;
    char x;

    public Node(char x, char y) {
      this.y = y;
      this.x = x;
    }
  }

  public static void main(String[] args) throws IOException {
    init();
    map = new HashMap<>();
    mapInit();
    String line = br.readLine(); // 처음이 x, 두번째 y
    Node king = new Node(line.split(" ")[0].charAt(0), line.split(" ")[0].charAt(1));
    Node stone = new Node(line.split(" ")[1].charAt(0), line.split(" ")[1].charAt(1));
    int n = Integer.parseInt(line.split(" ")[2]);

    for (int i = 0; i < n; i++) {
      String cmd = br.readLine();
      char ny = (char) (king.y + map.get(cmd)[0]);
      char nx = (char) (king.x + map.get(cmd)[1]);
      if (nx > 'H' || ny > '8' || nx < 'A' || ny < '1') {
        nx = (char) (king.y - map.get(cmd)[1]);
        ny = (char) (king.x - map.get(cmd)[0]);

        continue;
      }
      king.y = ny;
      king.x = nx;
      if (king.y == stone.y && king.x == stone.x) {
        // System.out.println("돌 이동");
        ny = (char) (stone.y + map.get(cmd)[0]);
        nx = (char) (stone.x + map.get(cmd)[1]);

        if (nx > 'H' || ny > '8' || nx < 'A' || ny < '1') {
          ny = (char) (ny - map.get(cmd)[0]);
          nx = (char) (nx - map.get(cmd)[1]);

          king.y = (char) (king.y - map.get(cmd)[0]);
          king.x = (char) (king.x - map.get(cmd)[1]);
        }
        stone.y = ny;
        stone.x = nx;
      }

    //   System.out.println("cmd: " + cmd + " king.x: " + king.x + " king.y: " + king.y);
    //   System.out.println("cmd: " + cmd + " stone.x: " + stone.x + " stone.y: " + stone.y);
    }
    bw.write(king.x + "" + king.y + "\n");
    bw.write(stone.x + "" + stone.y);

    close();
  }

  public static void mapInit() {
    for (int i = 0; i < 8; i++) {
      map.put(command[i], new int[] {dy[i], dx[i]});
    }
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
