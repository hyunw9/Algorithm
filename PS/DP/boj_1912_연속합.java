package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1912_연속합 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int[] arr;
    private static int[] memo;
    private static int max = -1001;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n];
        memo = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //첫번쨰 경우 연속 합
        memo[0] = arr[0];
        //배열을 순회하며 연속적인 값 계산
        for (int i = 1; i < arr.length; i++) {
            //핵심 로직, 배열의 현재값과 이전 누적합 + 현재 누적합을 비교해서 더 큰 것을 누적합 배열에 추가
            memo[i] = Math.max(arr[i],memo[i-1]+arr[i]);
        }
        //최대값 구하기
        for (int i = 0; i < memo.length; i++) {
            max = Math.max(max, memo[i]);
        }

        bw.write(max + "");
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
