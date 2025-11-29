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
    /*
    题目：24.两两交换链表中的节点 
    给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
    你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
    */
    public ListNode swapPairs(ListNode head) {
        /*
        思路：递归
        如果链表中至少有两个节点，则在两两交换链表中的节点之后，原始链表的头节点变成新的链表的第二个节点，
        原始链表的第二个节点变成新的链表的头节点。链表中的其余节点的两两交换可以递归地实现。
        在对链表中的其余节点递归地两两交换之后，更新节点之间的指针关系，即可完成整个链表的两两交换。
        */

        //递归结束条件  以1->2->3->4为例
        if(head == null || head.next == null){
            return head;
        }
        //
        ListNode newHead = head.next;
        //递归处理3->4
        //交换完变为4->3
        //再变为1->4->3
        head.next = swapPairs(newHead.next);
        newHead.next = head;//最后由2指向1,变为2->1->4->3
        return newHead;
    }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        /*
        思路：迭代
        首先创建哨兵节点，可以保存改变后的链表的头节点，然后交换两两相邻的节点，比如h1、h2，
        可以这样交换，h1.next = h2.next; h2.next = h1,这样可以交换两个节点位置，然后再以哨兵节点为依托，
        每次两个两个的前进，h1、h2交换完后，哨兵节点到h2，而h1、h2到h3、h4，当哨兵节点为空或其下一个节点为空，结束循环。
        */

        //创建哨兵节点，储存交换后链表的头节点位置，并于头节点相连，
        ListNode A = new ListNode(0);
        A.next = head;
        ListNode t = A;
        //当哨兵节点为空或其下一个节点为空，结束循环。
        while(t.next != null && t.next.next != null){
            //两个两个前进
            ListNode n1 = t.next;
            ListNode n2 = t.next.next;
            t.next = n2;
            //交换位置
            n1.next = n2.next;
            n2.next = n1;
            //哨兵节点变化到交换后的链表中的位置靠后的节点处
            t = n1;
        }
        return A.next;
    }
}