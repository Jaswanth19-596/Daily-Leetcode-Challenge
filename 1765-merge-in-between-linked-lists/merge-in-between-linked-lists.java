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
        ListNode tail = head;

        while(tail.next != null){
            tail = tail.next;
        }
        return tail;
    }

    ListNode move(ListNode list, int n){

        ListNode ptr = list;

        int i = 0;

        while(i < n){

            ptr = ptr.next;

            i++;
        }

        return ptr;

    }



    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list2;
        ListNode tail = getTail(list2);


        ListNode ptr1 = move(list1, a-1);
        ListNode ptr2 = move(list1, b);

        ptr1.next = head;
        tail.next = ptr2.next;
        ptr2.next = null;

        return list1;


    }
}