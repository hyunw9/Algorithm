package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1931_회의실배정2 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    List<Room> room = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      room.add(new Room(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
    room.sort(new Comparator<Room>() {
      @Override
      public int compare(Room o1, Room o2) {
        if(o1.end == o2.end){
          return o1.start-o2.start;
        }
        return o1.end-o2.end;
      }
    });
    int cnt = 0;
    int tld =0;
    for (Room room1 : room) {
      if(tld<= room1.start){
        tld = room1.end;
        cnt++;
      }
    }

    bw.write(cnt+"\n");
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

  private static class Room {

    int start;
    int end;

    public Room(int start, int end) {
      this.start = start;
      this.end = end;
    }

    public int getStart() {
      return start;
    }

    public int getEnd() {
      return end;
    }
  }

}
