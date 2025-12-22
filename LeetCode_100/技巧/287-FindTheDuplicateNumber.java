class Solution {
    /*
    287.寻找重复数  
    给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。

    注：假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
       你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
    */
    public int findDuplicate(int[] nums) {
        /*
        思路：环形链表、快慢指针
        根据给出的条件：
            元素范围[1,n]；
            元素个数：n+1；
            元素只有一个重复元素。
        可以运用求环形链表的环入口元素，先运用快慢指针求出相遇点，而后再通过这条定理：
        “从链表头到环入口的距离，等于从相遇点到环入口的距离”。
        可以求出重复数。
        根据上面给出条件，可以这样构造数组链表：slow = nums[slow]类似于read = read.next。
        */
        //设置快慢指针
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];//慢指针,类似于slow = slow.next
            fast = nums[nums[fast]];//快指针,类似于fast = fast.next.next
            if(slow == fast){//求出相遇点
                break;
            }
        }
        slow = 0;//重置起点
        while(slow != fast){//根据那个定理求出环入口
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }
}
