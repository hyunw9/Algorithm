package PS.Greedy;

import java.io.*;
import java.util.*;
public class boj_2785_체인 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            arr.add( Integer.parseInt(st.nextToken()));
        }
        Collections.sort(arr);
        int ans =0;
        while(true){
            if(arr.size()<=1){
                break;
            }
            arr.set(0,arr.get(0)-1);
            arr.remove(arr.size()-1);
            if(arr.get(0)==0){
                arr.remove(0);
            }
            ans+=1;
        }
        System.out.println(ans);
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
