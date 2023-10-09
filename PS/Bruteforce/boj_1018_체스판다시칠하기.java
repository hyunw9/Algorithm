package PS.Bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class boj_1018_체스판다시칠하기 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int min = 64;
    private static char [][]map ;
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        //배열 생성
        for (int i = 0; i < N; i++) {
            String line = new StringTokenizer(br.readLine()).nextToken();
            for (int j = 0; j < M; j++) {
                char now = line.charAt(j);
                map[i][j] = now;
                }
            }
        //map 내부에서 8번만큼 반복을 돌아야 합니다.
        //마치 프레임을 움직이는 것과 비슷한 구조입니다.
        for (int i = 0; i < N-7; i++) {
            for (int j = 0; j< M-7; j++) {
                bruteforce(i,j);
            }
        }

        bw.write(min+"");
        close();
    }

    public static void bruteforce(int row , int col ){
        //개수 카운트
        int cnt = 0;
        //현재 위치 색깔
        char color = map[row][col];

        //현재 위치로부터 8x8 반복을 진행
        for (int i = row; i < row + 8; i++) {
            for (int j = col; j < col + 8; j++) {

                //색이 불일치 할 경우 +1
                if(color != map[i][j]){
                    cnt+=1;
                }

                //현재 색 다음 색은 다른 색이어야 하므로 색 변경
                if(color == 'W'){
                    color = 'B';
                }else{
                    color = 'W';
                }
            }
            //행이 바뀔 경우도 마찬가지
            if(color == 'W'){
                color = 'B';
            }else{
                color = 'W';
            }
        }
        //cnt의 최솟값 구하기. 64-cnt는 반대 색깔의 경우입니다.
        cnt = Math.min(cnt,64-cnt);

        //전역변수 min 과 비교하여 최솟값 구하기
        min = Math.min(min,cnt);
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close () throws IOException {
        br.close();
        bw.close();
    }
}
