package leetCode.LinkedList;

import leetCode.LinkedList.linked_list_cycle.ListNode;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Merged_k_sorted_lists {

  public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length == 0) return null;

    PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(x-> x.val));
    for(ListNode node: lists){

      if(node != null) pq.add(node);
    }
    ListNode curr = new ListNode(-1);
    ListNode head = curr;
    while(!pq.isEmpty()){
      ListNode node = pq.poll();
      curr.next = node;
      curr = curr.next;
      if(node.next != null) pq.add(node.next);
    }

    return head.next;
  }

}
