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

    ListNode getTail(ListNode head){
        ListNode ptr = head;

        while(ptr.next != null){
            ptr = ptr.next;
        }

        return ptr;
    }

    ListNode move(ListNode head, int a){
        ListNode ptr = head;

        int i = 0;

        while(i < a){

            ptr = ptr.next;
            i++;
        }

        return ptr;      
    }



    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        
        ListNode secondListHead = list2;
        ListNode secondListTail = getTail(list2);

        // ListNode temp = new ListNode(0);

        // temp.next = list1;

        ListNode firstPtr = move(list1, a-1);
        ListNode secondPtr = move(list1, b);

        // System.out.println(firstPtr.val);
        // System.out.println(secondPtr.val);
        // System.out.println(secondListTail.val);
        
        firstPtr.next = secondListHead;
        secondListTail.next = secondPtr.next;

        secondPtr.next = null;

        return list1;


    }
}