package PS.floydWarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11404_플로이드 {
    static int INF = 987654321;
    static int [][]dist;
    static int N;
    static int M;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        sb=new StringBuilder();
        dist = new int[N+1][N+1];
        for (int i = 1; i <=N; i++) {
            for (int j = 1; j <=N ; j++) {

                dist[i][j] = INF;
            }
        }
        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b],c);
        }
        floyd();
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= N; j++) {
                if(i==j||dist[i][j]==INF){
                    dist[i][j]=0;
                }
                sb.append(dist[i][j]+ " ");

            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
    public static void floyd(){
        for (int k = 1; k <=N ; k++) {
            for (int i = 1; i <=N ; i++) {
                for (int j = 1; j <=N ; j++) {
                    dist[i][j] =Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }

        }
    }
}
