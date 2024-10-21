package PS.Greedy;

import java.io.*;
import java.util.*;
import java.math.*;

public class boj_민겸수_21314 {
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        
        char[] arr = br.readLine().toCharArray();

        String max = getMax(arr);
        String min = getMin(arr);
        

        System.out.println(max);
        System.out.println(min);
        
        close();
    }

    public static String getMax(char[] arr){
        ArrayDeque<String> dq = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();

        for(int i = arr.length-1; i>=0 ;){

            char start = arr[i];

            if(start =='K'){
                int cnt = 0;
                i-=1;
                while(i>=0 && arr[i]!='K'){
                    cnt+=1;
                    i-=1;
                }

                if(cnt ==0){
                    dq.addLast("5");
                }else{
                    BigInteger bi = new BigInteger("10");
                    dq.addLast(bi.pow(cnt).multiply(new BigInteger("5")).toString());
                }
                // i -=cnt;
            }else{
                // k가 아니면 m을 
                while(i>=0 && arr[i]=='M'){
                    dq.addLast("1");
                    i-=1;
                }

            }
            
        }
        while(!dq.isEmpty()){
            sb.append(dq.pollLast());
        }
        String num = sb.toString();
        BigInteger a = new BigInteger(num);
        return a.toString();
    }

    public static String getMin(char[] arr){
        ArrayDeque<String> dq = new ArrayDeque<>();
        StringBuilder sb= new StringBuilder();

        for(int i = arr.length -1;i>=0; ){
            char start = arr[i];
            if(start == 'K'){
                dq.addLast("5");
                i-=1;
            }else{
                int cnt = 0;
                while(i>=0 && arr[i]=='M'){
                    cnt+=1;
                    i-=1;
                }
                // System.out.println(cnt);
                if(cnt == 1){
                    dq.addLast("1");
                }else{
                    BigInteger bi = new BigInteger("10");
                    dq.addLast(bi.pow(cnt-1).toString());
                }

            }
        }
        while(!dq.isEmpty()){
            sb.append(dq.pollLast());
        }
        String num = sb.toString();
        BigInteger a = new BigInteger(num);
        return a.toString();

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