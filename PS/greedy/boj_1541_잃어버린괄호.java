package PS.Greedy;

import java.io.*;
import java.util.*;

public class boj_1541_잃어버린괄호 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    

    public static void main(String[] args) throws IOException {
        init();
        String line = br.readLine();
        char[] arr = line.toCharArray();

        int idx = 0;
        int sum =0;
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        while(idx <arr.length){
            
            if(arr[idx]>='0' && arr[idx]<='9'){
                sb.append(arr[idx]);
            }else{
                String strnum = sb.toString(); 
                int num =0; 
                if(!strnum.isEmpty()){
                    num = Integer.parseInt(strnum);
                }
                sb.setLength(0);
                if(flag){
                    sum += num*-1;
                }else{
                    sum += num;
                }
                System.out.println(sum);

                if(arr[idx] == '+'){
                    if(flag == true){
                        flag = true;
                    }
                }else if(arr[idx]=='-'){
                    if(flag == true){
                        flag = true;
                    }else if(flag == false){
                        flag = true;
                    }
                }
            }

            idx+=1;
        }
        if(flag){
            sum += -Integer.parseInt(sb.toString());
        }else{
            sum += Integer.parseInt(sb.toString());
        }
        System.out.println(sum);
    }

    public static void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
