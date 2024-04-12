package PS.TwoPointer;

import java.io.*;
import java.util.*;

public class boj_6198_옥상정원꾸미기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        long size = 0;
        for(int i = 0 ; i < n ; i++){

            long num = Integer.parseInt(br.readLine());

            while(!stack.isEmpty() && stack.peekFirst()<=num){
                stack.pollFirst();
            }
            size+=stack.size();
            stack.addFirst(num);
        }
        
        bw.write(size+"");
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
