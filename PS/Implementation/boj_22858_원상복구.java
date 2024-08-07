package PS.Implementation;

import java.io.*;
import java.util.*;
public class boj_22858_원상복구 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        //가 43125면 4번째 카드를 1번째로,3번째 카드를 2번째로 
        //반대로 풀려면 
        // 1 : 4
        // 2 : 3
        // 3 : 1
        // 4 : 2
        // 5 : 5
        //  3 5 1 4 2 를 각 hashmap으로 돌리면 
        //  1 4 5 3 2

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] res = new int[n];
        int[] rule = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0 ; i < n ; i ++){
            res[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            map.put(i,Integer.parseInt(st.nextToken())-1 );
        }
        System.out.println(map);
        


        for(int i = 0; i < k ; i++){
            int[]curr = new int[n];
            for(int j = 0 ;j < n ; j++){
                curr[j] = res[j];
            }
            for(int j = 0 ; j < n; j++){
                int loc = map.get(j);
                int tmp = res[loc];
                res[loc] = curr[j];
                // System.out.println("loc : "+ loc + " res[loc]: "+ res[loc]);
            }
        }
        for(int i : res){
            bw.write(i+" ");
        }
        close();
        //1 4 5 3 2 정답
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
