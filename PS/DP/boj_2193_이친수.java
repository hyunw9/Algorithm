package PS.DP;

import java.io.*;
import java.util.*;
public class boj_2193_이친수 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n= Integer.parseInt(br.readLine());

        long[] arr = new long[91];
        arr[0] = 0;
        arr[1]= 1;
        for(int i = 2; i<=90; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
        bw.write(arr[n]+"");
        close();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
