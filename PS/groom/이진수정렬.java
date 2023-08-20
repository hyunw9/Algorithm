package PS.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 이진수정렬 {
    public static class Number{
        String binaryNum ;
        int zerocnt;
        int num;

        public Number(String binaryNum, int zerocnt, int num) {
            this.binaryNum = binaryNum;
            this.zerocnt = zerocnt;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Number[] arr = new Number[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            String binaryNow = Integer.toBinaryString(now);
            arr[i] = new Number(binaryNow,countZero(binaryNow),now);
        }//int 10 진수 숫자를 -> String 2진수 문자열로

        Arrays.sort(arr,(Number o1, Number o2)->{
            if(o1.zerocnt == o2.zerocnt) return o2.num-o1.num;
            else{
                return o2.zerocnt-o1.zerocnt;
            }
        });

        for (Number number : arr) {
            System.out.println("원래 수: " + number.num +"  이진 수: "+number.binaryNum+"  1개수:"+number.zerocnt);

        }
        System.out.println(arr[K-1].num);
    }
    public static int countZero(String binaryNum){
        int cnt = 0;
        for (int i = 0; i < binaryNum.length(); i++) {
            if(binaryNum.charAt(i) == '1') cnt++;
        }
        return cnt;
    }
}
