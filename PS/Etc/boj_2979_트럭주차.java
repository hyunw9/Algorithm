package PS.Etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2979_트럭주차 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        int thr = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] fee = new int[101];
        for (int i = 0; i < fee.length; i++) {
            fee[i]=0;
        }
        for (int i = 0; i < 3; i++) {
            st=new StringTokenizer(br.readLine());
            int arrv = Integer.parseInt(st.nextToken());
            int dept = Integer.parseInt(st.nextToken());
            for (int j = arrv; j <dept ; j++) {
                fee[j] +=1;
            }    
            
        }

        for (int i = 1; i < fee.length; i++) {
            if(fee[i]== 1){
                result = one + result;
            }
            if(fee[i]== 2){
                result = two*2 +result;
            }
            if(fee[i]== 3){
                result = thr*3 +result;
            }
        }
        System.out.println(result);
        


    }
}
