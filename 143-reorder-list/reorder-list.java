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
        ListNode ptr = head;

        int count = 0;

        while(ptr != null){
            count++;
            ptr = ptr.next;
        }

        return count;
    }



    public void reorderList(ListNode head) {
        
        ListNode ptr = head;

        int n = length(head);

        if(n <= 2)  return;

        int i = 0;

        while(i < ((n/2) - 1)){
            ptr = ptr.next;
            i++;
        }

        ListNode head2 = ptr.next;
        ptr.next = null;



        Stack<ListNode> stack = new Stack<>();
        ListNode ptr2 = head2;

        while(ptr2 != null){
            stack.push(new ListNode(ptr2.val));

            ptr2 = ptr2.next;
        }


        ListNode curr = head;

        while(curr != null){
            ListNode next = curr.next;

            curr.next = stack.pop();

            curr = curr.next;
            curr.next = next;
            curr = next;
        }

        curr = head;

        while(curr.next != null){
            curr = curr.next;
        }

        while(stack.size() > 0){
            curr.next = stack.pop();
            curr = curr.next;
        }



        // return head;


    }
}