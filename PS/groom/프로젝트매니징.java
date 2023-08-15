package PS.groom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 프로젝트매니징 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int hr = Integer.parseInt(st.nextToken());
        int mm = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sum += Integer.parseInt(st.nextToken());
        }
        mm += sum;
        if(mm>=60){
            int addhr = mm/60;
            mm= mm % 60;
            hr+=addhr;
            hr%=24;

        }
        System.out.println(hr+" "+mm);
    }
}
