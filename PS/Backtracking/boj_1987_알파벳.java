package PS.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1987_알파벳 {
    static int R;
    static int C;
    static char[][] map ;
    static ArrayList<Character> arr;
    static boolean[] visited;
    static int []dx = {-1,1,0,0};
    static int []dy = {0,0,-1,1};
    static int res=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R= Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map=new char[R+1][C+1];
        visited = new boolean['Z'-'A'+1];
        arr = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            st=new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < C; j++) {
                map[i][j]= line.charAt(j);
            }
        }
        visited[map[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(res);

    }
    public static void dfs(int x, int y,int cnt){
        res=Math.max(res,cnt);
        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];
            if(xn<0 || yn < 0 || xn>=C ||yn >= R)
                continue;
            if(visited[map[yn][xn]-'A'])
                continue;
            visited[map[yn][xn]-'A'] = true;
            dfs(xn,yn,cnt+1);
            visited[map[yn][xn]-'A'] = false;


        }
    }

}
