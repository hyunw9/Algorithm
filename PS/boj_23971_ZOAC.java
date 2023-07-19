package PS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_23971_ZOAC {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int H = Integer.valueOf(st.nextToken());
        int W = Integer.valueOf(st.nextToken());
        int N = Integer.valueOf(st.nextToken());
        int M = Integer.valueOf(st.nextToken());
        int Height = (H-1)/(N+1) +1;
        int Width = (W-1)/(M+1) +1;
        System.out.println("Width*Height = " + Width*Height);

    }
}
