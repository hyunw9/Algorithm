package leetCode.LinkedList;

public class remove_nth_node_from_end_of_list {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode first = head;
    ListNode last = head;
    for (int i = 0; i < n; i++) {
      first = first.next;
    }
    if (first == null) {
      return head.next;
    }
    while (first.next != null) {
      first = first.next;
      last = last.next;
    }
    last.next = last.next.next;
    return head;
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


