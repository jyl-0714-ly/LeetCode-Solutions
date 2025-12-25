class Solution {
    /*
    题目：33.搜索旋转排序数组       
    整数数组 nums 按升序排列，数组中的值 互不相同 。

    在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 向左旋转，
    使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
    例如， [0,1,2,4,5,6,7] 下标 3 上向左旋转后可能变为 [4,5,6,7,0,1,2] 。

    给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

    你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
    */
    public int search(int[] nums, int target) {
        /*
        思路：二分查找
        因为这是个有序的数组，旋转后，依然是局部有序。nums[0]是大升序中最小的数，nums[nums.length - 1]是小升序中
        最大的数。当我们用二分查找mid索引时，就可以判断nums[mid]是在大升序中还是小升序中。
        当nums[mid]在大升序中时：target满足target >= nums[0] && target <= nums[mid]时，
        说明target在nums[mid]的左边，这时可以缩小范围了，反之在右边，亦可以缩小范围查找。
        当nums[mid]在小升序中时：同理略……
        */
        if(nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] <= nums[mid]){//判断nums[mid]是否在大升序中
                if(target >= nums[0] && target <= nums[mid]){//当target在大升序中
                    right = mid - 1;//在这之间舍去mid右边
                }else{
                    left = mid + 1;//反之舍弃mid左边
                }
            }else{//小升序中
                if(target >= nums[mid] && target <= nums[nums.length - 1]){//在小升序内
                    left = mid + 1;//舍弃mid左边
                }else{
                    right = mid - 1;//舍弃mid右边
                }
            }
        }
        return -1;
    }
}