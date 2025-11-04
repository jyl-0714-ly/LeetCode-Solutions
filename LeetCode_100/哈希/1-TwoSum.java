class Solution {
    /*
    题目：1.两数之和
    给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值target
    的那两个整数，并返回它们的数组下标。

    注：你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
        你可以按任意顺序返回答案。
    */
    public int[] twoSum(int[] nums, int target) {
        /*
        思路：核心思路，当target-nums[i]的时候，分为两种情况：
            1.当这个nums[i]是所求的数，那么target-nums[i]就等于另一个所求的数，
              并且target-nums[i]在nums数组中。
            2.当这个nums[i]不是所求的数，那么target-nums[i]无意义，
              并且target-nums[i]不在nums数组中。
            那么所求的就是nums[i]和target-nums[i]所对应的索引。
            那么就能够预见，可以利用键值对来写。
            如下代码：
        */
        Map<Integer, Integer> map = new HashMap<>();//先创建对象
        for (int i = 0; i < nums.length; i++) {//循环在map内添加键值对，边添加边对比
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };//这个只会产生一个答案
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
