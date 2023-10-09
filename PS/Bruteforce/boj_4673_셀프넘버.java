package PS.Bruteforce;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class boj_4673_셀프넘버 {
    private static BufferedWriter bw ;
    public static void main(String[] args) throws IOException {
        init();

        //10000까지 배열 생성
        boolean []arr = new boolean[10001];
        for (int i = 1; i < arr.length-1; i++) {
            //현재 인덱스(즉, 숫자)
            int num = i ;
            //나누면서 자리 수를 저장하는 변수
            int key = i;
            //자리수 덧셈 시작
            while(key>0){

                //현재 수 + 각 자리 수 덧셈 값
                num += key%10;
                key/=10;
            }

            //그렇게 해서 만들어진 수는 생성자가 존재하므로, 셀프 넘버가 아니게 됨, true 로 변경
            if(num>10000) continue;
            arr[num] = true;
        }
        //배열 돌며 false( 셀프 넘버 ) 만 출력
        for (int i = 1; i < arr.length-1; i++) {
            if(!arr[i]){
                bw.write(i+"\n");
            }
        }
        close();
    }

    public static void init(){
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        bw.close();
    }
}
