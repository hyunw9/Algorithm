package PS.Etc;

import java.io.*;
import java.util.*;

public class boj_1005_ACMCraft {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        int k =  Integer.parseInt(st.nextToken());
        int[] cost = new int[n+1];
        st= new StringTokenizer(br.readLine());
        for (int i = 1; i < cost.length-1; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for (int i = 1; i <= n ; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < k; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[start].add(end);
        }
 
        int target = Integer.parseInt(br.readLine());
        int offset = cost[target-1];
        Queue<Integer> q = new LinkedList<>();
        Queue<int[]> task = new LinkedList<>();
        int total = 0;
        // total += cost[1];
        q.offer(1);
        while(!q.isEmpty()){

            int curr = q.poll();

            for( int nxt :arr[curr]){
                q.offer(nxt);
                task.offer(new int[]{curr,nxt});
            }
        }

        while(!task.isEmpty()){

            int[] curr = task.poll();
            int c = cost[curr[0]];
            int max = cost[curr[1]];
            while(!task.isEmpty() && task.peek() == curr){
                max= Math.max(max,task.peek()[1]);
                task.poll();
            }
            if(!task.isEmpty()) cost[curr[1]] = max + c;
        }
        System.out.println(Arrays.toString(cost));
        bw.write((cost[target-1]+offset)+"");
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