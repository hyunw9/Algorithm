package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_10026_적녹색약 {
    static int N; //사이즈 담는 변수
    static char[][]general; //색들을 담는 맵
    static ArrayList<Integer> generalArray= new ArrayList<>(); //일반인이 구분하는 구역 담는 배열
    static ArrayList<Integer> blindArray= new ArrayList<>(); // 색약이 구분하는 구역 담는 배열
    static boolean[][]visited; //방문여부 담는 맵
    static int []dx = {-1,1,0,0}; //x축 이동 배열
    static int []dy = {0,0,-1,1}; //y축 이동 배열
    static int cnt = 0; //색이 각 몇개씩 존재하는지 구분을 위한 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        general = new char[N][N];
        visited = new boolean[N][N];
        //1. 반복 돌며 맵에 색깔 넣기
        for (int i = 0; i < N; i++) {
            st=new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < N; j++) {
                general[i][j] = line.charAt(j);
            }
        }
        //2. 일반인은 R,G,B를 구분할 수 있으므로, 각각의 경우에 대해서 dfs를 실행해줍니다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 1;
                char color = general[i][j];
                if(!visited[i][j]){
                    if(color == 'R') {
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }else if (color =='G'){
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }else if (color =='B'){
                        dfs(i, j, color);
                        generalArray.add(cnt);
                    }
                }
            }
        }
        //3. 이후 색약의 경우도 계산해야하기 때문에, 방문 배열 초기화
        visited = new boolean[N][N];
        //4. 색약의 경우 녹색과 빨강을 구분하지 못하므로 G를 R로 변환
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(general[i][j]=='G'){
                    general[i][j]='R';
                }
            }
        }
        //5. 똑같이 시행 후 배열에 값 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = 1;
                char color =general[i][j];
                if(!visited[i][j]){
                    if(color =='R' ){
                        dfs(i,j,color);
                        blindArray.add(cnt);
                    } else if (color =='B') {
                        dfs(i,j,color);
                        blindArray.add(cnt);
                    }
                }
            }
        }
        System.out.println(generalArray.size()+" "+blindArray.size());
    }

    private static void dfs(int x, int y, char c) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];

            if(xn >=0 && xn<N && yn>=0 && yn<N && !visited[xn][yn] && general[xn][yn]==c ){
                cnt+=1;
                dfs(xn,yn,general[xn][yn]);


            }
        }
    }
}
