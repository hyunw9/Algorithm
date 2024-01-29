package PS.Trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_14426_접두사찾기 {

  public static class Node{

    HashMap<Character,Node> children;
    int cnt ;

    public Node(){
      children = new HashMap<>();
      cnt = 0;
    }
  }
  private static Node root = new Node();
  private static BufferedReader br;
  private static BufferedWriter bw;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st= new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      insert(br.readLine());
    }
    int ans = m;
    for (int i = 0; i < m; i++) {

      String line = br.readLine();

      boolean flag = find(line);
        if(!flag){
          ans--;
        }
    }

    bw.write(ans+"");
    close();
  }

  public static void insert(String s){
    Node curr = root;
    for (char c : s.toCharArray()) {
      curr.children.computeIfAbsent(c,k -> new Node());

      curr.cnt +=1;
      curr = curr.children.get(c);
      curr.cnt+=1;
    }
  }
  public static boolean find(String s){
    Node curr= root;
    for (char c : s.toCharArray()) {
      if(!curr.children.containsKey(c)){
        return false;
      }else{
        curr = curr.children.get(c);
      }
    }
    return true;
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
