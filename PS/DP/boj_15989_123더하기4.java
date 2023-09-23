package PS.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_15989_123더하기4 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] memo ;
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        memo = new int[max+1];
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 3;
        float delimiter = 6;
        //찾은 규칙: i > 3 일 때, memo[4] = memo[1] + 3
        //                    memo[5] = memo[2] + 3
        //                    memo[6] = memo[3] + 4
        //                    memo[7] = memp[4] + 4
        for (int i = 4; i <= max; i++) {
            delimiter = delimiter/2;
            memo[i] = memo[i-3] + (int)delimiter ;
            delimiter*=2;
            delimiter++;
        }
        for (int i = 0; i < N; i++) {
            bw.write(memo[arr[i]]+"\n");
            bw.flush();
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
}
