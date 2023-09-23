package PS.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_20310_타노스 {
    private static BufferedReader br;
    private static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        StringBuilder sb = new StringBuilder();
        char[] arr = new char[s.length()];
        boolean [] removed = new boolean[arr.length];
        //Arrays.fill(removed,false);

        for (int i = 0; i < s.length(); i++) {
             arr[i] = s.charAt(i);
        }
        int zero= 0;
        int one = 0;
        //0 과 1 카운트
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '0'){
                zero +=1;
            }
            if(arr[i] == '1'){
                one++;
            }
        }

        zero /= 2;
        one /= 2;
        //사전순으로 배치해야 하므로, 0은 최대한 뒤에서부터 지워주기
        int idx = arr.length-1;
        while(zero>0){
            if(arr[idx] == '0'){
                removed[idx] = true;
                zero--;
            }
            idx--;
        }
        //같은 이유로, 1은 앞쪽부터 지우기
        idx = 0;
        while(one > 0){
            if(arr[idx]=='1'){
                removed[idx] = true;
                one--;
            }
            idx++;
        }
        //지워져있는 칸은 건너뛰고 문자열 화
        for (int i = 0; i < arr.length; i++) {
            if(removed[i]){
                continue;
            }
            sb.append(arr[i]);
        }
        bw.write(sb.toString());
        close();
    }
    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public static void close() throws IOException {
        br.close();
        bw.close();
    }
}
