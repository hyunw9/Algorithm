package PS.graph;

import java.io.*;
import java.util.*;
public class boj_13549_숨바꼭질3 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        // 코드를 작성하세요.
        int sum = 0;

        //방문 체크 셋
        HashMap<Integer,Integer> map = new HashMap<>();

        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[100001]; // 방문 여부 체크

        q.add(new int[]{n, 0});
        visited[n] = true;

        while(!q.isEmpty()){

            int[] now = q.poll();
            int curr= now[0];
            int time = now[1];

            int[] next ={curr*2,curr-1,curr+1};
            
            if(curr==k){
                bw.write(time+"");
                break;
            }
            for(int nxt : next){
                if(nxt <0 || nxt >100000 || visited[nxt]) continue;

                visited[nxt] = true;
                if(nxt == curr * 2){
                    q.add(new int[]{nxt,time});
                }else{
                    q.add(new int[]{nxt,time+1});
                }
            }
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
