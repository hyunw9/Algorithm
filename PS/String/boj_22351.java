package PS.String;

import java.io.*;
import java.util.*;
public class boj_22351 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();

        String line = br.readLine();
        int len = line.length();
        //앞의 자리 수는 1부터 
        //앞 숫자보다 큰 뒷 숫자를 구한다. 3까지 
        //1,1  1,2 1,3
        //2,2, 2,3 
        //3,3
        int first = Integer.MAX_VALUE;
        int last = len;
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <=3; i++){
            int front = 0;
            if(i<len){
            front = Integer.parseInt(line.substring(0,i));
            }
            int end =0;
            //뒤가 더 큰 수 구하기 

            for(int j = 1; j<=line.length(); j++){
                if(end>front) break;
                end = Integer.parseInt(line.substring(len-j,len));
            }

            for(int j = front; j<=end;j++){
                sb.append(j);
            }
            if(sb.toString().length() == len) {
                // bw.write(front +" " + end);
                if(front < first ){
                    first = front;
                    last = end;
                }

            }
            sb.setLength(0);
        }

        System.out.println(first +" "+ last);
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
