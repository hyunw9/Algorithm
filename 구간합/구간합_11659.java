package 구간합;

import javax.sql.RowSetInternal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class 구간합_11659 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = parseInt(st.nextToken());
        int N = parseInt(st.nextToken());
        int[] input = new int[M+1];

        st = new StringTokenizer(br.readLine());
        input[1] = Integer.parseInt(st.nextToken()) ;
        for (int i = 2; i <= M ; i++) {
            input[i]=input[i-1] + Integer.parseInt(st.nextToken());
        }
        for (int i = 0;i<N ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            bw.write(input[b] - input[a-1]+"\n");
        }
        bw.flush();

    }


}





