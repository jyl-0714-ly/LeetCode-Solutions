class Solution {
    /*
    题目：45.跳跃游戏||     
    给定一个长度为 n 的 0 索引整数数组 nums。初始位置在下标 0。

    每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在索引 i 处，你可以跳转到任意 (i + j) 处：

    0 <= j <= nums[i] 且
    i + j < n
    返回到达 n - 1 的最小跳跃次数。测试用例保证可以到达 n - 1。
    */
    public int jump(int[] nums) {
        /*
        思路：贪心算法
        每次记录每一个数组元素的最远处，并同时遍历每个数组元素，当这个最远处变化时，跳跃次数+1，
        当遍历到最后一个元素时，此时的跳跃次数就是答案
        */
        int ans = 0;
        int curRight = 0;//已建造的桥的右端点
        int nextRight = 0;//下一座桥的右端点的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            //遍历的过程中，记录下一座桥的最远点
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) {//无路可走，必须建桥
                curRight = nextRight;//建桥后，最远可以到达 next_right
                ans++;
            }
        }
        return ans;
    }
}