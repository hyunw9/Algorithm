package PS.Implementation;

import java.io.*;
import java.util.*;
public class boj_1620_나는야포켓몬마스터이다솜 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String,Integer> map = new HashMap<>();
        ArrayList<String> arr= new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < n ; i ++){
            String line =br.readLine();
            map.put(line , i+1);
            arr.add(line);
        }
        for(int i = 0 ; i < m ; i++){
            String cmd = br.readLine();
            if(Character.isDigit(cmd.charAt(0))){
                bw.write(arr.get(Integer.parseInt(cmd)-1)+"\n");
            }else{
                bw.write(map.get(cmd)+"\n");
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
