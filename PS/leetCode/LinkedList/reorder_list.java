package PS.leetCode.LinkedList;

public class reorder_list {

  public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

  public void reorderList(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode node = reverseList(slow.next);
    slow.next = null;
    ListNode curr = head;
    ListNode dummy = node;
    while(head != null && dummy!= null){

      ListNode tmp = curr.next;

      curr.next = dummy;

      ListNode tmp2 = dummy.next;

      dummy.next = tmp;
      curr = tmp;
      dummy = tmp2;

    }

  }

  public ListNode reverseList(ListNode node){
    ListNode prev = null;
    ListNode curr = node;
    ListNode tmp = null;
    while(curr != null){
      tmp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = tmp;

    }
    return prev;
  }

}
