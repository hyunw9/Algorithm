package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://www.acmicpc.net/problem/2839
public class boj_2389_설탕배달 {

    static BufferedReader br;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        while (true) {
            //5로 나누어 떨어질 경우 count에 더하고 탈출
            if (N % 5 == 0) {
                count += N / 5;
                break;
                //음수 일 경우 설탕을 나를 수 없음
            } else if (N < 0) {
                count = -1;
                break;
            }
            //5로 나누어 떨어지지 않는다면 -3 하여 다시 따지기
            N = N - 3;
            count += 1;
        }

        bw.write(count+"");
        bw.flush();
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
