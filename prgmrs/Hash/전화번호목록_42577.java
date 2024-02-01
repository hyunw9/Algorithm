package prgmrs.Hash;

import java.util.HashMap;

public class 전화번호목록_42577 {

  static class Node{
    HashMap<Character,Node> children;
    boolean isLeaf;

    public Node(){
      this.children = new HashMap<>();
      this.isLeaf = false;
    }
  }

  public static Node root = new Node();

  public boolean solution(String[] phone_book) {
    boolean answer = true;
    for(int i =0 ; i < phone_book.length; i++){
      insert(phone_book[i]);
    }
    for(int i =0 ; i < phone_book.length; i++){
      if(!search(phone_book[i])){
        return false;
      }
    }
    return true;
  }

  public static void insert(String line){

    Node curr = root;

    for(int i = 0; i <line.length(); i++){
      char c = line.charAt(i);

      if(curr.children.containsKey(c)){
        curr = curr.children.get(c);
      }else{
        Node next = new Node();
        curr.children.put(c,next);
        curr = curr.children.get(c);
      }
    }
    curr.isLeaf = true;
  }

  public static boolean search(String line){

    Node curr = root;

    for(int i = 0; i<line.length();i++){
      char c = line.charAt(i);

      if(curr.isLeaf && !curr.children.isEmpty()){
        return false;
      }else{
        curr=  curr.children.get(c);
      }

    }
    return true;
  }

}
