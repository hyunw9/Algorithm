package PS.TopologicalSort;

import java.io.*;
import java.util.*;

public class boj_2623_음악프로그램 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] degree;
    private static ArrayList<Integer> ans;
    private static ArrayList<Integer>[] graph;
    private static int n; 
    private static int m;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        degree = new int[n+1];

        graph = new ArrayList[n+1];
        

        for(int i = 0 ; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for(int j = 0; j < count-1; j++){
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                degree[to]++;
                from = to;
            }
        }
        if(topologicalSort()){
            for(int a : ans){
                System.out.println(a);
            }
        }else{
            System.out.println(0);
        };

         close();
    }
    public static boolean topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        ans = new ArrayList<>();

        for(int i = 1 ; i < degree.length; i++){
            if(degree[i]==0){
                q.offer(i);
                ans.add(i);
            }
        }
        

        while(!q.isEmpty()){
            int curr = q.poll();

            for(int next : graph[curr]){
                degree[next]-=1;
                if(degree[next]== 0){
                    q.offer(next);
                    ans.add(next);
                }
            }
        }

        return ans.size()==n;
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
