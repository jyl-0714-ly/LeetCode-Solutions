class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[len - 1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return nums[left];
    }
}