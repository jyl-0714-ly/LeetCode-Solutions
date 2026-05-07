/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode A = head;
        ListNode B = head;
        while (B != null && B.next != null) {
            A = A.next;
            B = B.next.next;
            if (A == B) {
                ListNode C = head;
                while (C != A) {
                    C = C.next;
                    A = A.next;
                }
                return A;
            }
        }
        return null;
    }
}