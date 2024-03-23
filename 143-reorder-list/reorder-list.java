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

    int length(ListNode head){
        int count = 0;
        ListNode ptr = head;
        while(ptr != null){
            ptr = ptr.next;
            count++;
        }
        return count;
    }

    ListNode reverse(ListNode head){

        ListNode curr = head, prev = null;

        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;


    }


    public void reorderList(ListNode head) {
        int count = length(head);

        if(count <= 2)  return;

        int skip = (count + 1)/2 - 1;

        ListNode ptr = head;
        for(int i = 0;i<skip;i++){
            ptr = ptr.next;
        }

        ListNode list2 = ptr.next;
        ptr.next = null;

        ListNode revList2 = reverse(list2);

        ListNode ptr1 = head, ptr2 = revList2;

        while(ptr1 != null && ptr2 != null){
            ListNode next1 = ptr1.next;
            ListNode next2 = ptr2.next;

            ptr1.next = ptr2;
            ptr2.next = next1;

            ptr1 = next1;
            ptr2 = next2;
        }


    }
}