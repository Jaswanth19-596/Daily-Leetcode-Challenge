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

    int getLength(ListNode head){
        int count = 0;
        ListNode ptr = head;
        while(ptr != null){
            count++;
            ptr = ptr.next;
        }
        return count;
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getLength(head);

        if(length == n){
            return head.next;
        }

        ListNode ptr = head;
        for(int i = 0;i<length - n - 1;i++){
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        return head;
    }
}