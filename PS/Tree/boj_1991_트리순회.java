package PS.Tree;

import com.sun.source.tree.Tree;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1991_트리순회 {

  private static BufferedReader br;
  private static BufferedWriter bw;

  private static class Node{
    Node left;
    Node right;
    String node;
    boolean isLeaf;

    public Node(String key){

      this.node = key;

      this.isLeaf = false;
    }
  }

  public static Node root;
  public static int n;
  public static StringBuilder sb;
  public static void main(String[] args) throws IOException {
    init();
    root = new Node("A");
    sb= new StringBuilder();
    StringTokenizer st = new StringTokenizer(br.readLine());
     n = Integer.parseInt(st.nextToken());
    for(int i =0 ; i < n ; i++){
      st= new StringTokenizer(br.readLine());
      String parent = st.nextToken();
      String lc = st.nextToken();
      String rc = st.nextToken();

      insert(root,parent,lc,rc);
    }
    Node curr = root;
    first(curr);
    bw.write(sb.toString()+"\n");
    sb.setLength(0);
    curr= root;
    middle(curr);
    bw.write(sb.toString()+"\n");
    sb.setLength(0);
    curr= root;
    back(curr);
    bw.write(sb.toString()+"\n");
    close();
  }
  public static void insert(Node curr, String parent,String left, String right){


    if(curr.node.equals(parent)){
      if(!left.equals(".")) {
        curr.left = new Node(left);
      }
      if(!right.equals(".")) {
        curr.right = new Node(right);
      }
      return;
    }else{
      if(curr.left != null){
        insert(curr.left, parent,left,right);
      }
      if(curr.right != null){
        insert(curr.right, parent,left,right);
      }
    }

  }

  public static void first(Node curr){
    sb.append(curr.node);
    if(curr.left != null) first(curr.left);
    if(curr.right != null) first(curr.right);
  }
  public static void middle(Node curr){
    if(curr.left !=null) middle(curr.left);
    sb.append(curr.node);
    if(curr.right!=null) middle(curr.right);
  }

  public static void back(Node curr){
    if(curr.left !=null) back(curr.left);
    if(curr.right!=null) back(curr.right);
    sb.append(curr.node);

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
