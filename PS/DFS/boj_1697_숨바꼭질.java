package PS.DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class boj_1697_숨바꼭질 {

    //최대 배열 크기
    public static final int MAX_LENGTH = 100001;

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static ArrayDeque<Integer> dq;

    private static int N;
    private static int K;
    private static boolean []used;
    private static int answer;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        dq = new ArrayDeque<>();
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        used= new boolean[MAX_LENGTH];
        //현재 위치는 방문 한 것으로 체크
        used[N] = true;
        dq.addLast(N);
        //Bfs
        bfs();
        System.out.println("used[17] = " + used[17]);
        bw.write(answer+"");
        close();
    }

    public static void bfs() {
        //정답 초기화
        answer = 0;

        while (!dq.isEmpty()){
            int size = dq.size();
            //한 요소 별로 3개씩의 노드가 생길 수 있음. 첫 번째 예시는 4,6,10 임
            for(int i=0; i<size; i++){
                int now = dq.pollFirst();
                //정답일 경우 리턴
                if(now == K){
                    return;
                }
                //-1하여 q에 삽입. 방문체크하여 방문하였을 시 continue
                if(now-1 >= 0 && !used[now-1]) {
                    used[now-1] = true;
                    dq.addLast(now-1);
                }
                //+1하여 q에 삽입. 방문체크하여 방문하였을 시 continue
                if(now+1 < MAX_LENGTH && !used[now+1]) {
                    used[now+1] = true;
                    dq.addLast(now+1);
                }
                //*2하여 q에 삽입. 방문체크하여 방문하였을 시 continue
                if(now*2 < MAX_LENGTH && !used[now*2]) {
                    used[now*2] = true;
                    dq.addLast(now*2);
                }
            }
            //한번 순회하여 큐에 값을 모두 집어넣었으면 1초가 걸림(이동했음) 따라서 초 증가
            answer += 1;
        }
        //답을 못찾았다면 -1
        answer = -1;
    }

    public static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
