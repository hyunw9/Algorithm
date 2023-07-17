package boj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import static java.lang.System.in;

public class boj_1904_01타일 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb= new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int []arr = new int[N+1];
        if(N<4){
            for (int i = 0; i < N+1; i++) {
                arr[i] = i;
            }
        }else {
            //간단한 DP문제이지만, 4부터 값이 변동이 있으므로 3까지는 직접 대입
            arr[0] = 0;
            arr[1] = 1;
            arr[2] = 2;
            arr[3] = 3;

            for (int i =4; i <N+1 ; i++) {
                arr[i] = (arr[i-1] + arr[i-2])% 15746;
            }
        }


        sb.append(arr[N]);
        System.out.println(sb);
    }
}
