# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def getIntersectionNode(self, headA: ListNode, headB: ListNode) -> Optional[ListNode]:
        # Observation
        # 8, 4, 5 are the common nodes for both the lists
        # 8 is the first node

        myset = set()

        ptr1 = headA
        while ptr1:

            myset.add(ptr1)
            ptr1 = ptr1.next

        ptr2 = headB

        while ptr2:
            if ptr2 in myset:
                return ptr2
            else:
                ptr2 = ptr2.next

        return None