package PS.Implementation;

import java.io.*;
import java.util.*;
public class boj_20114_미아노트 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        char[] answer = new char[n];
        char[][] arr= new char[h][n*v];
        for(int i = 0 ; i < h ; i ++){
            String line = br.readLine();
            for(int j = 0 ; j < arr[0].length; j++){
                arr[i][j] = line.charAt(j);
            }
        }
        //옆, 아래
        for(int i = 0 ; i< h; i++){
            for(int j = 0 ; j < n*v-1; j++){
                if(arr[i][j+1]!='?'){
                    arr[i][j]=arr[i][j+1];
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.deepToString(arr));

        close();
    }

    private static void init() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    private static void close() throws IOException {
        br.close();
        bw.close();
    }
}
