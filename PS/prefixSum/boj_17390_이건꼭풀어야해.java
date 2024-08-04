package PS.prefixSum;

import java.io.*;
import java.util.*;
public class boj_17390_이건꼭풀어야해 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<Integer> arr =new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i <n ; i++){
            arr.add( Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        int[] sum = new int[n+1];
        sum[0] = 0;
        for(int i = 1 ; i <= n ; i++){
            sum[i]+=arr.get(i-1)+sum[i-1];
        }
        System.out.println(Arrays.toString(sum));
        for(int i = 0 ; i < q ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            System.out.println(sum[to]-sum[from-1]);
        }
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