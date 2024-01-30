package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_14891_톱니바퀴 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static String[] map;
  private static int n;
  private static boolean[] changed;
  private static int sum;

  public static void main(String[] args) throws IOException {
    init();
    map = new String[5];
    for (int i = 1; i <= 4; i++) {
      map[i] = br.readLine();
    }
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int wheel = Integer.parseInt(st.nextToken());
      int dir = Integer.parseInt(st.nextToken());
//      changed = new boolean[5];
//      change(wheel,dir);
//      changed[wheel] = true;
      search(wheel,dir,true,true);
    }
//    System.out.println(Arrays.deepToString(map));
    sum();
    System.out.println(sum);
    close();
  }

  public static void sum() {
    for (int i = 1; i <= 4; i++) {
      String line = map[i];
      if (i == 1) {
        if (line.charAt(0) != '0') {
          sum += 1;
        }
      } else if (i == 2) {
        if (line.charAt(0) != '0') {
          sum += 2;
        }
      } else if (i == 3) {
        if (line.charAt(0) != '0') {
          sum += 4;
        }

      } else if (i == 4) {
        if (line.charAt(0) != '0') {
          sum += 8;
        }

      }
    }
  }


  public static void search(int wheel, int dir, boolean left, boolean right) {
    if (wheel < 1 || wheel > 4) {
      return;
    }

    int leftGear= wheel -1;
    int rightGear = wheel +1;
//    if (!changed[wheel]) {
      if(left && leftGear>=1 && map[wheel].charAt(6)!= map[leftGear].charAt(2)){
        search(leftGear, -dir,true,false);
      }
      if(right && rightGear<=4 && map[wheel].charAt(2)!=map[rightGear].charAt(6)){
        search(rightGear,-dir,false,true);
      }
      change(wheel,dir);
//      changed[wheel]=true;
//    }
  }


  public static void change(int wheel, int dir) {
    if (dir == -1) {
      char now = map[wheel].charAt(0);
      map[wheel] = map[wheel].substring(1, 8) + now;
    } else {
      char now = map[wheel].charAt(7);
      map[wheel] = now + map[wheel].substring(0, 7);
    }
    //System.out.println(map[wheel]);
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
