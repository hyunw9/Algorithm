package PS.Math;

import java.io.*;
import java.util.*;
public class boj_11720_숫자의합 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        int sum = 0 ;
        String line = br.readLine();
        for(int i = 0; i < n; i++){
            sum += line.charAt(i)-'0';
        }
        bw.write(sum+"");

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
