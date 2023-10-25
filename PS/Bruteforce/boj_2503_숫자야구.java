package PS.Bruteforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2503_숫자야구 {

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static boolean[] arr ;

    public static void main(String[] args) throws IOException{
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        arr = new boolean[1000];
        for (int i = 123; i <988 ; i++) {
            int first = i/100 % 10;
            int second = i/10 % 10;
            int third = i % 10 ;
            arr[i] = true;
            if(first == second || second == third || first == third) {
                arr[i] = false;
            }
            if(first ==0 || second == 0|| third == 0){
                arr[i] = false;
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            for (int j = 123; j <988; j++) {
                if(arr[j]){
                    int s = 0;
                    int b = 0;
                    for(int first=0;first<3;first++){
                        char now_split = Integer.toString(j).charAt(first);

                        for(int second=0;second<3;second++){
                            char ans_split = Integer.toString(j).charAt(second);
                            if(now_split == ans_split && first == second) {
                                s++;
                            }
                            else if(now_split == ans_split && first != second) {
                                b++;
                            }
                        }
                    }
                    if (s != strike || b != ball) {
                        arr[j] = false;
                    }
                }
            }
        }
        int ans = 0;
        for(int i=123;i<1000;i++){
            if(arr[i]) ans++;
        }
        bw.write(ans+"");
        close();
    }

    public static void init(){
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    public static void close() throws IOException {
        br.close();
        bw.flush();
        bw.close();
    }
}
