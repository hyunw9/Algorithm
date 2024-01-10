package PS.MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1922_네트워크 {

  private static BufferedReader br;
  private static BufferedWriter bw;
  private static int[] cycle;
  private static Node[] nodes;
  private static List<Node> mst;
  private static int sum;

  public static void main(String[] args) throws IOException {
    init();
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    int m = Integer.parseInt(st.nextToken());
    nodes = new Node[m];
    cycle = new int[n + 1];
    for (int i = 1; i <=n; i++) {
      cycle[i] = i;
    }
    mst = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(nodes, new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        return o1.cost - o2.cost;
      }
    });

    for (Node node : nodes){
//      System.out.println(node.start + " " + node.end +" "+ node.cost);
//      System.out.println(Arrays.toString(cycle));

      if(find(node.start)!=find(node.end)){
        union(node.start,node.end);
        mst.add(node);
        sum+=node.cost;
      }
    }
    bw.write(sum+"");
    close();
  }

  public static int find(int x){
    if(cycle[x]== x){
      return x;
    }
    return cycle[x] = find(cycle[x]);
  }

  public static void union(int l, int r){
    cycle[find(l)] = find(r);
  }

  public static void init() {
    br = new BufferedReader(new InputStreamReader(System.in));
    bw = new BufferedWriter(new OutputStreamWriter(System.out));
  }

  public static void close() throws IOException {
    br.close();
    bw.close();
  }

  static class Node {

    int start;
    int end;
    int cost;

    public Node(int start, int end, int cost) {
      this.start = start;
      this.end = end;
      this.cost = cost;
    }
  }

}
