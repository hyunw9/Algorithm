package leetCode.trie;

import java.util.HashMap;

public class implement_prefix_tree {
  class PrefixTree {

    private Node root;

    class Node {

      private boolean isEnd;
      private HashMap<Character, Node> child;
      private char curr;

      public Node(char value) {
        this.isEnd = false;
        this.child = new HashMap<>();
        this.curr = value;
      }
    }

    public PrefixTree() {
      this.root = new Node('\0');
    }

    public void insert(String word) {
      Node curr = root;
      for (char c : word.toCharArray()) {
        if (!curr.child.containsKey(c)) {
          Node next = new Node(c);
          curr.child.put(c, next);
        }
        curr = curr.child.get(c);
      }
      curr.isEnd = true;
    }

    public boolean search(String word) {
      Node curr = root;

      for (char v : word.toCharArray()) {
        if (!curr.child.containsKey(v)) {
          return false;
        }
        curr = curr.child.get(v);
      }
      if (!curr.isEnd) return false;
      return true;
    }

    public boolean startsWith(String prefix) {
      Node curr = root;

      for (char v : prefix.toCharArray()) {
        if (!curr.child.containsKey(v)) {
          return false;
        }
        curr = curr.child.get(v);
      }
      return true;
    }
  }
}
