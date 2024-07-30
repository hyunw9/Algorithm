package PS.Backtracking;

import java.io.*;
import java.util.*;
public class boj_1497_기타콘서트 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    // private static char[][] arr;
    private static long[] guitarBit;
    private static int minGuitarCnt = 987654321; 
    private static int maxSong;
    private static int n;
    private static int m;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
        // arr = new char[n][m];
        guitarBit = new long[n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            char[] arr = st.nextToken().toCharArray();
            for(int j = 0 ; j < m; j ++){
                if(arr[j]=='Y'){
                    guitarBit[i] |= (1L << j);
                }
            }
        }
        System.out.println(Arrays.toString(guitarBit));
        dfs(0,0L, 0);
        if(minGuitarCnt == 0){
            System.out.println(-1);
        }else{
            System.out.println(minGuitarCnt);
        }
        close();
    }

    public static void dfs(int idx, long guitarMask , int cnt) {
        int bitCount = Long.bitCount(guitarMask);

        if(bitCount == maxSong && cnt < minGuitarCnt ){
            minGuitarCnt = cnt;
        }

        if(bitCount > maxSong){
            minGuitarCnt = cnt;
            maxSong = bitCount;
        }

        if(bitCount == m || idx == n){
            return;
        }

        dfs(idx +1, guitarMask | guitarBit[idx], cnt+1);
        dfs(idx +1, guitarMask ,cnt);


        }

    public static int checkPlay(char[] available , boolean[] played){
        int cnt=0 ;
        for(int i = 0 ; i < m ; i++){
            if(!played[i] && available[i]=='Y'){
                played[i] = true;
                cnt +=1;
            }
        }
        return cnt;
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
