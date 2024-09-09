package PS.Backtracking;

import java.io.*;
import java.util.*;

public class boj_17208_카우버거 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static boolean []used ;
    private static List<int[]> arr;
    private static int max;
    private static int n;
    private static int m;
    private static int K;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[m+1][K+1];

        for(int o = 0; o < n; o++){    
            st = new StringTokenizer(br.readLine());
            int cheese = Integer.parseInt(st.nextToken());
            int potato = Integer.parseInt(st.nextToken());
            for(int i = m ; i> 0 ; i--){
                for(int k = K; k>0; k--){
                    if(cheese<=i && potato <= k){
                        dp[i][k] = Math.max(dp[i][k], dp[i-cheese][k-potato]+1);
                    }
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        System.out.println(dp[m][K]);
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
/*
** 간략한 풀이 : 처음에 백트래킹으로 풀었다. 근데 냅색문제임. 항상 시간복잡도를 고민하는 습관을 갖자
* 또, 냅색은 뒤부터 계산해야 중복갱신을 피할 수 있다. 
* e.g. 감튀 5일 때, 주문이 2가 들어와서 처리하면 감튀가 3이 된다.
* 근데, 1부터 시작할경우, 이전 상태를 무시한 채, 처리하게 되어서 숫자가 더 높게 나올 수 있다. 
*/