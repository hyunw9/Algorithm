package PS.Recursion;

import java.io.*;
import java.util.*;
public class boj_1110_더하기사이클 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int target ;
    private static int count ;

    public static void main(String[] args) throws IOException {
        init();
        target = Integer.parseInt(br.readLine());
        int n = (target%10*10)+(target/10 + target%10)%10;
        count+=1;
        while(n != target){
            n = (n%10*10)+(n/10 + n%10)%10;
            count+=1;
        }
        System.out.println(count);
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
