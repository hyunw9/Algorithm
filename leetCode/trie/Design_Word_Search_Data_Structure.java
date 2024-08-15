package leetCode.trie;

import java.util.HashMap;

public class Design_Word_Search_Data_Structure {
  class WordDictionary {

    Node root;

    class Node {
      HashMap<Character, Node> child;
      char val;
      boolean isEnd;

      public Node(char val) {
        this.child = new HashMap<>();
        this.val = val;
        this.isEnd = false;
      }
    }

    public WordDictionary() {
      this.root = new Node('\0');
    }

    public void addWord(String word) {
      Node curr = root;

      for (char w : word.toCharArray()) {

        if (!curr.child.containsKey(w)) {
          Node next = new Node(w);
          curr.child.put(w, next);
        }

        curr = curr.child.get(w);
      }
      curr.isEnd = true;
    }

    public boolean search(String word) {
      return dfs(word, 0, root);
    }

    private boolean dfs(String word, int j, Node root) {
      Node curr = root;

      for (int i = j; i < word.length(); i++) {
        char c = word.charAt(i);
        if (c == '.') {
          for (Node next : curr.child.values()) {
            if (dfs(word, i + 1, next)) {
              return true;
            }
          }
          return false;
        } else {
          if (!curr.child.containsKey(c)) {
            return false;
          }
          curr = curr.child.get(c);
        }
      }
      return curr.isEnd;
    }
  }
}
