class Solution {
    /*
    题目：41.缺失的第一个正数       
    给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

    请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
    */
    public int firstMissingPositive(int[] nums) {
        /*
        思路：该算法通过原地哈希（in-place hashing）思想，将数组 nums 本身当作哈希表：遍历数组，
        把每个在 [1, n] 范围内的正整数 x 放到下标 x-1 的位置上（即“让学号为 x 的学生坐到第 x 个座位”）；
        完成重排后，第一个 nums[i] != i+1 的位置 i 对应的 i+1 就是缺失的最小正整数；若全部匹配，
        则答案是 n+1。
        */
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 如果当前学生的学号在 [1,n] 中，但（真身）没有坐在正确的座位上
            while (1 <= nums[i] && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                // 那么就交换 nums[i] 和 nums[j]，其中 j 是 i 的学号
                int j = nums[i] - 1; // 减一是因为数组下标从 0 开始
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        // 找第一个学号与座位编号不匹配的学生
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // 所有学生都坐在正确的座位上
        return n + 1;
    }
}