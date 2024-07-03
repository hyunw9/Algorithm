package PS.greedy;

import java.io.*;
import java.util.*;
public class boj_1092_배 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        
        int n = Integer.parseInt(br.readLine());
        Integer[] crane = new Integer[n];
        StringTokenizer st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane,Collections.reverseOrder());
        int m = Integer.parseInt(br.readLine());
    
        Integer[] boxes = new Integer[m];
        st= new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(boxes,Collections.reverseOrder());

        System.out.println(Arrays.toString(crane));
        System.out.println(Arrays.toString(boxes));

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
