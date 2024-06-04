package PS.graph;

import java.io.*;
import java.util.*;
public class boj_4386_별자리만들기 {

    static class Node{
        double x;
        double y;

        public Node(double x, double y){
            this.x = x;
            this.y =y;
        }
    }
    
    static class Edge{
        int a;
        int b;
        double dist;

        public Edge(int a, int b, double dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
    }

    private static BufferedReader br;
    private static BufferedWriter bw;
    private static int[] star;
    public static void main(String[] args) throws IOException {
        init();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        List<Node> arr = new ArrayList<>();
        for(int i = 0; i < n ; i++){
            st= new StringTokenizer(br.readLine());
            float a= Float.parseFloat(st.nextToken());
            float b= Float.parseFloat(st.nextToken());
            arr.add(new Node(a,b));
        }
        star = new int[n];
        for ( int i = 0 ; i < n ; i++){
            star[i] =i;
        }
        List<Edge>cost = new ArrayList<>(); 
        for (int i = 0 ; i < n ; i++){
            for (int j = 0 ;j < n ; j++){
                if (i != j){
                    double distance = getDist(arr.get(i),arr.get(j));
                    System.out.println("distance: "+ distance);
                    cost.add(new Edge(i,j,distance));
                }
            }
        }
        Collections.sort(cost,(o1,o2) -> Double.compare(o1.dist,o2.dist));
        double answer =0;
        for (int i = 0; i <cost.size();i++){
            Edge now = cost.get(i);
            System.err.println(now.a + " "+ now.b+ " "+now.dist+ " : ");
            if(find(now.a)!=find(now.b)){
                union(now.a,now.b);
                answer+=now.dist;
            }
        }
        bw.write(answer+"");
        close();
    }
    public static double getDist(Node a, Node b){
        return (Math.sqrt(Math.pow(  a.x - b.x ,2) + Math.pow(a.y-b.y , 2)));
    }

    public static int find(int x){
        if(star[x]==x){
            return x;
        }
        return find(star[x]);
    }

    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a!=b){
            if(a<b){
                star[b] =a;
            }else{
                star[a]=b;
            }
        }
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
