package PS.Stack;

import java.io.*;
import java.util.*;
public class boj_2493_탑 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        Stack<Integer> tk =new Stack<>();
        st= new StringTokenizer(br.readLine());
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        for(int i = 0 ; i < n ; i ++){

            int tmp = Integer.parseInt(st.nextToken());

            map.put(tmp,i+1);

            while(!tk.isEmpty() && tk.peek()<= tmp){
                tk.pop();
            }

            if(tk.isEmpty()) {
                ans.add(0);
            }else{
                ans.add(tk.peek());
            }

            tk.push(tmp);
        }
        for(int val : ans){
            bw.write(map.get(val)+" ");
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
