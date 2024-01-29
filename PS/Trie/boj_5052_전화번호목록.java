package PS.Trie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class boj_5052_전화번호목록 {

  private static class Node{
    HashMap<Character,Node> children;
    boolean isLeaf;
    public Node(){
      children = new HashMap<>();
      isLeaf = false;
    }
  }
  private static BufferedReader br;
  private static BufferedWriter bw;
  private static Node root ;

  public static void main(String[] args) throws IOException {
    init();
    int t = Integer.parseInt(br.readLine());
    for (int i = 0; i < t; i++) {
      root = new Node();
      int n = Integer.parseInt(br.readLine());
      String[] arr = new String[n];
      for (int j = 0; j < n; j++) {
        arr[j] = br.readLine();
        insert(arr[j]);
      }
      boolean flag = true;
      for (int j = 0; j < n; j++) {
        if(!isPrefix(arr[j])){
          flag = false;
          break;
        }
      }
      if(!flag) bw.write("NO\n");
      else bw.write("YES\n");
    }
    close();
  }

  public static void insert(String s){

    Node curr = root;
    for (char c : s.toCharArray()) {
      curr.children.computeIfAbsent(c,k->new Node());
      curr = curr.children.get(c);
    }
    curr.isLeaf = true;
  }
  public static boolean isPrefix(String s ){
    Node curr = root;

    for (char c : s.toCharArray()) {
      if(curr.isLeaf){
        if(!curr.children.isEmpty()){
          return false;
        }
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
