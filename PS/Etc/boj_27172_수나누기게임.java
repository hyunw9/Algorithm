package PS.Etc;

import java.io.*;
import java.util.*;
public class boj_27172_수나누기게임 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        init();
        // 3
        // 3 4 12
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        int max = 0;
        

        for(int i= 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max= Math.max(arr[i],max);
        }
        boolean[] card =new boolean[max+1];
        for(int num: arr){
            card[num]  = true;
        }
        int[] map = new int[max+1];
        

        for(int v : arr){

            for(int i = v*2; i<=max; i+=v){
                if(card[i]){
                    map[i]-=1;
                    map[v]+=1;
                }
            }
        }
        // 3 4 12 
        for(int num : arr){
            bw.write(map[num]+" ");
        }
        
// 3 6 9 12 
// 4 8 12 
// 12 
// 7 14 21
// 23 46
// 8 16 24
// 6 12 18 24 
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