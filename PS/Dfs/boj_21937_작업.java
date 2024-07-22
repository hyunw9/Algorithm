package PS.Dfs;

import java.io.*;
import java.util.*;
public class boj_21937_작업 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int target ; 
    private static int workload;
    private static ArrayList<Integer>[]adj;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adj = new ArrayList[n+1];
        for(int i = 0 ; i <= n ; i ++){
            adj[i] = new ArrayList<>();
        }

        int[] degree = new int[n+1];
        for(int i = 0 ; i < m ; i ++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            adj[start].add(end);
            degree[end]+=1;
        }
        st = new StringTokenizer(br.readLine());
        target = Integer.parseInt(st.nextToken());
        int[] cnt = new int[n+1];
        Queue<Integer> q= new LinkedList<>();

        for(int i = 1; i <=n ;i++){
            if(degree[i] == 0){
                q.offer(i);
                while(!q.isEmpty()){
                    int curr = q.poll();
                    for(int nxt : adj[curr]){
                        cnt[nxt]+= cnt[curr]+1;
                        q.offer(nxt);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(cnt));
        bw.write(cnt[target]+"");
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