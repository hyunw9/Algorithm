package PS.Greedy;
 
import java.io.*;
import java.util.*;

public class boj_2195_문자열복사 {

    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] a = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        char[] b = st.nextToken().toCharArray();

        int r = 0;
        int cnt =0;
        while(r<b.length){

            int offset =0;

            int idx = r; 

            for(int k = 0 ; k< a.length; k++){
                
                // if(idx >= b.length) break;

                int correct = 0;
                if(b[idx]==a[k]){
                    int j = k ;
                    int dum = idx;
                    while((dum<b.length && j < a.length ) && b[dum]==a[j]){
                        // System.out.println("j: "+ j);
                        // if((dum<b.length && j < a.length )) System.out.println("b[dum]: "+ b[dum]+ " a[j]: "+ a[j]);

                        dum+=1;
                        j+=1;
                        correct+=1;
                    }
                    offset = Math.max(offset,correct);
                    // System.out.println(offset);

                }
                
            }
            
            r+=offset;
            cnt+=1;

        }
        System.out.println(cnt);
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
