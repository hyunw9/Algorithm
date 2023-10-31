package PS.Bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_18429_근손실 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int n;
    private static int k;
    private static int[] workout;
    private static boolean[] used;
    private static int answer;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        workout = new int[n];
        used = new boolean[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            workout[i] = Integer.parseInt(st.nextToken());
        }
        answer = 0;
        bt(500, 0);
        bw.write(answer + "");
        bw.close();
    }

    public static void bt(int cnt, int idx) {
        if (idx == n) {
            answer++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!used[i] && (cnt + workout[i] - k) >= 500) {
                used[i] = true;
                bt(cnt + workout[i] - k, idx + 1);
                used[i] = false;
            }
        }
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
