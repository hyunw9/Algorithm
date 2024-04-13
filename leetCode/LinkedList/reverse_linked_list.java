package leetCode.LinkedList;

public class reverse_linked_list {

  public ListNode reverseList(ListNode head) {
    if (head == null) {
      return head;
    }
    ListNode cur = head;
    ListNode prev = null;
    ListNode tmp = null;
    while (cur != null) {

      tmp = cur.next;
      cur.next = prev;
      prev = cur;
      cur = tmp;

    }
    return prev;
  }

  public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

}
