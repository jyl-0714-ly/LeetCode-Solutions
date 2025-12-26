class Solution {
    /*
    题目：153.寻找旋转排序数组中的最小值       
    已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
    例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
    若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
    若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]

    注意，数组 [a[0], a[1], a[2], ..., a[n-1]]旋转一次的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。

    给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
    请你找出并返回数组中的 最小元素 。

    你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
    */
    public int findMin(int[] nums) {
        /*
        思路：二分查找
        通过nums[mid]与nums[n-1]对比，来不断缩小最小值位置，
            当nums[mid] > nums[n-1]时：最小值在mid右边
            当nums[mid] <= nums[n-1]：最小值在mid左边
        以这两个条件不断缩小范围，从而查到最小值。
        */
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[n-1]){//最小值在mid右边
                left = mid + 1;
            }else{//最小值在mid左边
                right = mid - 1;   
            }
        }
        return nums[left];
    }
}