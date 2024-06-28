package PS.TwoPointer;

import java.io.*;
import java.util.*;
public class boj_15831_준표와조약돌 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int maxb = Integer.parseInt(st.nextToken());
        int maxw = Integer.parseInt(st.nextToken());
        char[] road=  br.readLine().toCharArray();
        int maxSize = 0;
        //sliding window ? 윈도우 최대값을 반환하면 될 것 같다. 
        // left 가 늘어나는 시점은 b개수가 초과할 경우. 윈도우를 이동해야한다. 
        int l = 0;
        int r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('W',0);
        map.put('B',0);
        int wcnt = 0;
        int bcnt = 0;
        while(l<=r && r < n){
           
            
            if(road[r]=='B'){
                bcnt+=1;
            }else{
                wcnt+=1;
            }
            if(bcnt >maxb){
               // l이 b까지 당겨져야 함. 
               while(bcnt>maxb){
                if(road[l]=='B') bcnt -=1;
                else wcnt-=1;
                ++l;
               } 
            }

            int winsize = r-l +1;
            // System.out.println("l: "+ l + " r : "+ r +" winSIZE = "+ winsize + " bcnt : "+ bcnt + " wcnt : "+ wcnt );
            if(wcnt >= maxw && bcnt<=maxb){
                // System.out.println("read l & r : "+ l + " "+ r );
                maxSize = Math.max(maxSize,winsize);
            }
            r++;

            //max 갱신은 B, W 조건 검증 이후에 . 
        }
        System.out.println(maxSize);

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
