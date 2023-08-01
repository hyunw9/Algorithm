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
                //배열 무한대로 값 초기화
                dist[i][j] = INF;
            }
        }
        StringTokenizer st;

        for (int i = 1; i <= M; i++) {
            //a에서 b로 가는 간선의 값 갱신. 현재 값보다, 입력받는 c가 작다면 교체
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dist[a][b] = Math.min(dist[a][b],c);
        }
        floyd();
        for (int i = 1; i <=N ; i++) {
            for (int j = 1; j <= N; j++) {
                //거리가 무한이거나 i==j, 자기 자신인 경우는 거리 0 이므로 갱신
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
                    //i, j, k 가 있다고 할 시, i 에서 j 로 가는 비용을 계산한다.
                    // i 에서 k로 갔다가 k 에서 j 로 가는 거리가 직접 i->j 로 가는 값 보다 더 작다면 교체한다.
                    dist[i][j] =Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }

        }
    }
}
