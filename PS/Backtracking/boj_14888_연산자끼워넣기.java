package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_14888_연산자끼워넣기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    private static int[] arr;

    private static int[] op;

    private static int N;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        bt(arr[0], 1);
        bw.write(max + "\n" + min);
        close();
    }

    public static void bt(int num, int idx) {
        //인덱스가 N, 즉 모두 연산했을 때 최소값 최대값 갱신
        if (idx == N) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            return;
        }
        //연산자 배열 순회
        for (int i = 0; i < 4; i++) {

            //연산할 수 있으면 해당 연산 카운트 감소
            if (op[i] > 0) {
                op[i] -= 1;

                //각 연산자는 인덱스가 정해져 있음, +:0, -:1, *:2, /:3
                if (i == 0) {
                    bt(num + arr[idx], idx + 1);

                } else if (i == 1) {
                    bt(num - arr[idx], idx + 1);

                } else if (i == 2) {
                    bt(num * arr[idx], idx + 1);

                } else if (i == 3) {
                    bt(num / arr[idx], idx + 1);

                }
                //사용한 인덱스는 원상복귀
                op[i] += 1;
            }

        }
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
