package PS.greedy; 

import java.io.*;
import java.util.*;
public class boj_1946_신입사원 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st=new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashMap<Integer,Integer> map = new HashMap<>();
            int scr = N;
            for (int j = 0; j < N; j++) {
                st= new StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            for (int j = 1; j <= map.size(); j++) {
                if (j == 1) continue;
                if(map.get(j)>map.get(j-1)){
                    map.put(j,map.get(j-1));
                    scr--;
                }
            }
            sb.append(scr+"\n");
        }
        System.out.println(sb);
    }
}
