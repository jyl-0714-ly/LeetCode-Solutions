class Solution {
    /*
    题目：42.接雨水     
    给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
    */
    public int trap(int[] height) {
        /*
        思路：使用双指针从两端向中间遍历，同时维护左侧最大高度（preMax）和右侧最大高度
        （sufMax）；在每一步中，较小的一侧决定了当前能接多少水（因为水位由较矮的边界限制），
        将该侧当前位置的积水高度（max - height[i]）累加到结果中，并移动对应指针，
        从而高效计算出总雨水量。
        */
        int ans = 0;
        int preMax = 0; // 前缀最大值，随着左指针 left 的移动而更新
        int sufMax = 0; // 后缀最大值，随着右指针 right 的移动而更新
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            sufMax = Math.max(sufMax, height[right]);
            if (preMax < sufMax) {
                ans += preMax - height[left];
                left++;
            } else {
                ans += sufMax - height[right];
                right--;
            }
        }

        return ans;
    }
}