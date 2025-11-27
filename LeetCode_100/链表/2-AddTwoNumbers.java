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
    题目：2.两数相加    
    给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。

    注： 请你将两个数相加，并以相同形式返回一个表示和的链表。
        你可以假设除了数字0之外，这两个数都不会以0开头。
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /*
        思路：因为这个事逆序的方式存储的非负整数，则可以从头节点开始，两两相加。
        为了避免因为两个链表长度不一造成的计算漏错，应该为较短的那个链表补零。
        得到两两相加的值之后，创建一个新节点接受这个值。
        */

        //哨兵节点，可以存储所求的链表的头节点
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        //中间变量t，用于存储进位的值
        int t = 0;
        //两个链表都遍历完才可以返回
        while(l1 != null || l2 != null){
            //判断l1或l2是否为null，来确定什么时候补零，什么时候取值
            int m = l1 == null ? 0 : l1.val;
            int n = l2 == null ? 0 : l2.val;
            //计算对应的两个链表值的和
            int num = m + n + t;
            //根据值的和，计算应该置入对应的新链表的值
            int sum = num%10;
            //将sum，置入新链表
            cur.next = new ListNode(sum);
            //计算下一次应该进位的值
            t = num/10;
            cur = cur.next;
            //只有不为null的时候，才能有next
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }    
        }
        //当最后一轮循环所求num>10的时候，也就是说需要进1，但是循环已经结束，所以额外加这个循环判断是否存在这个额外值
        if(t == 1){
            cur.next = new ListNode(t);
        }
        //返回哨兵节点保存的所求链表的头节点
        return pre.next;
    }
}