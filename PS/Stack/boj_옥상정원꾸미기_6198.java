package PS.Stack;

import java.io.*;
import java.util.*;
public class boj_옥상정원꾸미기_6198 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        int n = Integer.parseInt(br.readLine());
        long[] arr= new long[n];
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st =new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Long> stack = new ArrayDeque<>();
        long answer = 0;
        for (int i = 0 ; i < n; i++){

            long now = arr[i];
            while(!stack.isEmpty() && stack.peekFirst() <= now){
                stack.pollFirst();
            }
            answer += stack.size();
            stack.addFirst(now);
        }
        bw.write(answer+"");
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
