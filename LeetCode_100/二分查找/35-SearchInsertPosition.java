class Solution {
    /*
    题目：35.搜索插入位置   35-SearchInsertPosition.java
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
    如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

    注：请必须使用时间复杂度为 O(log n) 的算法。
    */
    public int searchInsert(int[] nums, int target) {
        /*
        思路：遍历
        因为nums已经是排序数组，当target<=nums[i]时，说明他的索引就是i，
        额外的情况就是当这个数在最后，然后不会进if语句，那么就是所在位置索引为i+1
        */
        int len = nums.length;
        int ans = 0;
        for(int i = 0; i<len; i++){
            if(target<=nums[i]){
                ans = i;
                break;
            }
            ans = i+1;
        }
        return ans;
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        /*
        思路：二分查找
        因为是排过序的，通过找中间位置元素，然后比大小，往两边去，在数据量大时，查找速度快。
        */
        int len = nums.length;
        int left = 0, right = len - 1, ans = len;
        while(left<=right){
            int min = (right - left)/2 + left;//这样找中间点，避免left+right溢出
            if(target <= nums[min]){
                ans = min;
                right = min - 1;
            }else{
                left = min + 1;
            }
        }
        return ans;
    }
}