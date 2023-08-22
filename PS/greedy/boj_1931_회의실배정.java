package PS.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931_회의실배정 {
    public static class Room{
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        Room[] arr = new Room[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Room(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr, new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                if(o1.end == o2.end)
                    return o1.start-o2.start;
                return o1.end-o2.end;
            }
        });

        int cut = 0;
        for (Room room : arr) {
            int start = room.start;
            int end = room.end;

            if(start>=cut){
                cnt+=1;
                cut = end;
            }
        }
        System.out.println(cnt);
    }
}
