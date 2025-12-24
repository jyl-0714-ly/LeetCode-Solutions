class Solution {
    /*
    题目：34.在排序数组中查找元素的第一个和最后一个位置
    给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。

    注：如果数组中不存在目标值 target，返回 [-1, -1]。
    你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
    */
    public int[] searchRange(int[] nums, int target) {
        /*
        思路：二分查找
        可以写一个函数，这个函数查找target的最小索引值，只要nums[mid] >= target，这个条件，
        就能求出target的最小索引值，然后求出最小索引后，再通过求target+1的最小索引值，然后这个值-1，
        就是target的最大索引值。
        */
        //求target的索引最小值
        int start = lowerBound(nums, target);
        //当这个索引越界或索引所对应值不等于target时，返回-1
        if(start == nums.length || nums[start] != target){
            return new int[]{-1,-1};
        }
        //求target的索引最大值
        int end = lowerBound(nums, target+1)-1;
        return new int[]{start,end};
    }
    private int lowerBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            //安全的中间值
            int mid = left + (right - left)/2;
            if(nums[mid] >= target){//重点，这样可以一直压缩target的索引范围，直到最小值
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
}