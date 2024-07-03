package PS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1002_터렛 {

    private static BufferedReader br ;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int []arr = new int[6];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            bw.write(getCount(arr)+"\n");
        }

        close();
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }

    public static int getCount(int[] arr){
        int x1 = arr[0];
        int y1 = arr[1];
        int dist1 = arr[2];
        int x2 = arr[3];
        int y2 = arr[4];
        int dist2 = arr[5];

        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));	// 중점간 거리 distance의 제곱

        // case 1 : 중점이 같으면서 반지름도 같을 경우
        if(x1 == x2 && y1 == y2 && dist1 == dist2) {
            return -1;
        }

        // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
        else if(distance_pow > Math.pow(dist1 + dist2, 2)) {
            return 0;
        }

        // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
        else if(distance_pow < Math.pow(dist2 - dist1, 2)) {
            return 0;
        }

        // case 3-1 : 내접할 때
        else if(distance_pow == Math.pow(dist2 - dist1, 2)) {
            return 1;
        }


        // case 3-2 : 외접할 때
        else if(distance_pow == Math.pow(dist1 + dist2, 2)) {
            return 1;
        }

        else {
            return 2;
        }
    }
}
