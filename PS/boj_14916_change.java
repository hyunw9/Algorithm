package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14916_change {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int tmp = num;

        int count = 0;

        if (num % 5 == 0){
            count = num /5 ;
        }else{
            if(num >1 && num !=3){
            count = num / 5;
            num = num % 5;


            if(num % 2 == 0 ){
                count = count + num/2;
            } else if (num %2 != 0) {
                num = num +5 ;
                count --;
                count = count + num/2;
            }
            }else{
                count = -1;
            }
        }
        System.out.println(count);
    }
}
