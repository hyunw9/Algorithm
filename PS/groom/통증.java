package PS.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 통증 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int cnt = 0;
        for (int i = N; i >=0; i--) {
            if(N>=14){
                N-=14;
                cnt++;
            }
            else if (N<14 && N>=7) {
                N-=7;
                cnt++;
            } else if (N<7 && N >=1) {
                N-=1;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
