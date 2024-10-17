package PS.Implementation;

import java.io.*;
import java.util.*;

public class boj_1316_그룹_단어_체커 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        //핵심은 떨어진 그게 있는가 ? 
        // 그냥 불린으로 체크하면 되잖아 ? 

        int cnt = 0;
        int t = Integer.parseInt(st.nextToken());
        for(int i = 0 ;i < t; i++){
            String line = br.readLine();

            boolean[] used = new boolean[26];
            boolean flag = false;
            for(int j = 0; j < line.length() ; ){

                char curr = line.charAt(j);
            
                int idx = 0;
                while(j < line.length() && curr == line.charAt(j)){
                    System.out.println("curr: "+ line.charAt(j) );
                    if(used[line.charAt(j)-'a']){
                        flag = true;
                    }
                    j+=1;
                    idx +=1;
                }
                used[curr-'a'] = true;
                // j += idx;
            }
            if(!flag) cnt+=1;
            System.out.println(Arrays.toString(used));
        
        }
        System.out.println(cnt);
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

/*
** 간략한 풀이 :
*/