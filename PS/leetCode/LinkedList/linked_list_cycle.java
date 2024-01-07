package PS.leetCode.LinkedList;

public class linked_list_cycle {

  static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public static class Solution {

    public boolean hasCycle(ListNode head) {
      for (int i = 0; i < 100000; i++) {
        if (head == null) {
          return false;
        }
        head = head.next;
      }
      return true;
    }

  }
}
