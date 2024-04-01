package PS.DP;
import java.io.*;
import java.util.*;

public class boj_11660_누적합구하기5 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i = 1; i <= n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j<= n ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                }
        }

        dp[0][0]=map[0][0];
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j<=n ; j++){
                    dp[i][j]= dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        for(int i = 1 ; i <=m; i++){
            st= new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // System.out.println("y1: "+ y1 + " x1 : "+ x1 +" y2: "+ y2+ " x2: "+ x2);
            int sum = dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1];
            bw.write(sum+"\n");
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