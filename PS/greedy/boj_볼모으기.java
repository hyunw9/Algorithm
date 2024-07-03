package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_볼모으기 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    
    public static void main(String[] args) throws IOException {
        init();
        //   Red를 옮기냐,  Blue 를 옮기냐? 
        // 양 끝이 무엇이냐에 따라서 결정된다. 
        // 한쪽 끝이 B 면 blue, r 면 red를 움직여야 하는데
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int min =Integer.MAX_VALUE;

        min = Math.min(min,move(n,arr));
        System.out.println(min);

        close();
    }

    public static int move(int n, char[]arr){
        Stack<Character> stack = new Stack<>();
        char offset = arr[0];
        int min =Integer.MAX_VALUE;
        int idx =0 ;
        int Rcount =0;
        int Bcount = 0;
        if(offset == 'R' && n>=2){
            //r이 아닐때까지 탐색하며 offset 검색 
            // n까지 탐색하며 r개수 확인 
            while(idx +1 < n &&arr[++idx]=='R'){
            }
            for(int i = idx+1 ; i< n; i++){
                if(arr[i]=='R') {
                    Rcount +=1;
                }
            }
            for(int i = 0; i<n ; i++){
                if(arr[i]=='B'){
                    Bcount+=1;
                }
            }

        }else if(offset =='B' && n>=2){
            //b가 아닐때까지 탐색하며 Offset 검색 
            while(idx+1 < n && arr[++idx]=='B'){
            }

            for(int i = idx+1; i<n; i++){
                if(arr[i]=='B'){
                    Bcount+=1;
                }
            }
            for(int i = 0; i<n ; i++){
                if(arr[i]=='R'){
                    Rcount+=1;
                }
            }
        }
        // System.out.println(Rcount+ " "+ Bcount ); 

        min  = Math.min(min,Math.min(Rcount,Bcount));
        Rcount = 0;
        Bcount =0;
        offset=arr[n-1];
        idx = n-1;
        if(offset == 'R'&&n>=2){
            while(idx-1>=0 && arr[--idx]=='R'){}
            for(int i = idx; i>=0; i--){
                if(arr[i]=='R') Rcount+=1;
                else Bcount+=1;
            }
        }else if(offset =='B' && n>=2){
            while(idx-1>=0 && arr[--idx]=='B'){}
            for(int i = idx; i>=0; i--){
                if(arr[i]=='B') Bcount+=1;
                else Rcount+=1;
            }
        }
        // System.out.println(Rcount+ " "+ Bcount ); 
        min  = Math.min(min,Math.min(Rcount,Bcount));

        return min; 
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