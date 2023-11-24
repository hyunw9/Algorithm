package PS.구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1244_스위치켜고끄기 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    boolean[] switches = new boolean[n];
    Arrays.fill(switches, false);
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      if (st.nextToken().equals("1")) {
        switches[i] = true;
      }
    }
    st = new StringTokenizer(br.readLine());
    int m = Integer.parseInt(st.nextToken());
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int type = Integer.parseInt(st.nextToken());
      int num = Integer.parseInt(st.nextToken());

      if (type == 1) {
        for (int l = 1; l <= n; l++) {
          int j = num * l - 1;
          if(j>=n) break;
          switches[j] = !switches[j];
        }
      } else {
        int j = 1;
        switches[num - 1] = !switches[num - 1];
        while (num - j - 1 >= 0 && num + j - 1 < n) {
          if (switches[num - j - 1] == switches[num + j - 1]) {
            switches[num - j - 1] = !switches[num - j - 1];
            switches[num + j - 1] = !switches[num + j - 1];
          }else{
            break;
          }
          j++;
        }
      }
    }
    int cnt =1;
    for (int i = 0; i < switches.length; i++) {
      if(switches[i]) {
        sb.append(1+" ");
      }else{
        sb.append(0+" ");
      }
      cnt ++;

      if(cnt==21){
        sb.append("\n");
        cnt = 1;
      }
    }
    bw.write(sb.toString());
    close();
  }
  public static void init(){
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.flush();
    bw.close();
  }

}
