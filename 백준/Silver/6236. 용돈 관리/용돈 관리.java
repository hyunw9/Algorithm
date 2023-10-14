

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long low = 0;
        long high = 0;
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            high+=arr[i];
            low = Math.max(low, arr[i]);
        }

        while (low <= high) {
            long mid = (low + high) / 2;
            long balance = mid;
            int times = 1;

            for (int j : arr) {
                if (balance < j) {
                    balance = mid;
                    times++;
                }
                balance -= j;
            }

            if (times > M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        bw.write(low + "");
        close();
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
