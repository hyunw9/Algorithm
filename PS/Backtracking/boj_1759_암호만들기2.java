package PS.Backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_암호만들기2 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int l;
  private static int c;
  private static char[] alphabet;
  private static boolean[] used;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    alphabet = new char[c];
    used = new boolean[c];

    for (int i = 0; i < c; i++) {
      char now = st.nextToken().charAt(0);
      alphabet[i] = now;
    }
    Arrays.sort(alphabet);
    dfs(0, 0, "", 0);
    //System.out.println(Arrays.toString(alphabet)) ;
    close();
  }

  public static void dfs(int ja, int mo, String curr, int depth) throws IOException {
    if (depth == l && ja > 1 && mo > 0) {

      bw.write(curr + "\n");
      return;
    }

    for (int i = depth; i < alphabet.length; i++) {
      if (!used[i]) {
        if (depth > 0 && (curr.charAt(depth - 1) > alphabet[i])) {
          continue;
        }
        if (depth > l) {
          continue;
        }

        used[i] = true;
        if (alphabet[i] == 'a' || alphabet[i] == 'e' || alphabet[i] == 'i'
            || alphabet[i] == 'o' || alphabet[i] == 'u') {
          dfs(ja, mo + 1, curr + alphabet[i], depth + 1);
        } else {
          dfs(ja + 1, mo, curr + alphabet[i], depth + 1);
        }
        used[i] = false;
      }
    }
  }


  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

}
