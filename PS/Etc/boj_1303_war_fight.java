package PS.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class boj_1303_war_fight {

    static int M;
    static int N;
    static int count = 0;
    static boolean[][]visited;
    static char[][]area;
    static int sumW = 0 ;
    static int sumB = 0 ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        area = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j <M ; j++) {
                area[i][j] = line.charAt(j);

            }
        }

        for (int i = 0; i <N ; i++) {
            for (int j = 0; j <M ; j++) {
                if(!visited[i][j]) {
                   count=0;
                    dfs(i, j, area[i][j]);
                    int strength = count * count;
                        if(area[i][j]=='W'){
                            sumW += strength;
                        }else{
                            sumB += strength;
                        }
                }
        }
    }
        System.out.println(sumW+" "+sumB);
    }
    public static void dfs(int x, int y , char k){
        visited[x][y] = true;
        count +=1;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];

             if((0<=yn && yn <M &&0<=xn && xn<N)&&
                     (!(visited[xn][yn]) && area[xn][yn]== k)){
                dfs(xn,yn,k);
            }
        }

    }
}
