package PS.String;

import java.io.*;
import java.util.*;
public class boj_3005_크로스워드퍼즐쳐다보기 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] map = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split("");
            // st = new StringTokenizer(br.readLine());
            for(int j = 0 ;j < m ; j++){
                if(line[j].equals("#")){
                    map[i][j]=" ";
                }else{
                    map[i][j] =line[j];
                }
            }
        }
        // System.out.println(Arrays.deepToString(map));
        List<String> arr =new ArrayList<>();
        for(int i = 0; i < n ; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ; j < m;j++){
                    sb.append(map[i][j]);
            }
            String[] list = sb.toString().split(" ");
            for(String s : list){
                arr.add(s);
            }
            sb.setLength(0);
            for(int j = 0 ; j < n; j++){
                if(i<m) sb.append(map[j][i]);
            }
            list  = sb.toString().split(" ");
            for(String s : list){
                arr.add(s);
            }
        }
        Collections.sort(arr);
        // System.out.println(arr);
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i).length()<2) continue;
            else{
                System.out.println(arr.get(i));
                break;
            }
        }
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
