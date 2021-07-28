/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<lists.length;i++){
            ListNode l = lists[i];
            while(l!=null){
                pq.offer(l.val);
                l= l.next;
            }
            
        }
        int size =pq.size();
        if(size==0) return null;
        
         ListNode head = new ListNode();
         ListNode current = head;
        for(int i=0;i<size;i++){
            current.val = pq.poll();
            if(i!=size-1){
                current.next = new ListNode();
                current=current.next;
            }
        }
        return head;
        
    }
}