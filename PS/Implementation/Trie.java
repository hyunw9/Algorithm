package PS.Implementation;

import java.util.HashMap;

public class Trie {

  private static int answer ;

  static class Node{

    private  HashMap<Character, Node> child;
    private  int cnt ;

    public Node(){
      child = new HashMap<>();
    }
  }

  public static int solution(String[] words) {
    Node root = new Node();
    for(int i = 0; i<words.length; i++){
      insert(root,words[i]);
    }
    for(int i = 0 ; i < words.length; i++){
      check(root,words[i]);
    }
    return answer;
  }

  public static void insert(Node curr, String str){
    for(char a : str.toCharArray()){
      curr = curr.child.computeIfAbsent(a,l -> new Node());
      curr.cnt++;
    }
  }

  public static void check(Node curr, String str){
    for( char a : str.toCharArray()){
      curr = curr.child.get(a);
      answer++;
      if(curr.cnt == 1) return;
    }
  }

  public static void main(String[] args){
    String[] a = {"123","1234","12345"};
    System.out.println(solution(a));
  }

}
