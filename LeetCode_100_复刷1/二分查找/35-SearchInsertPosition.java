class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1, ans = len;
        while(left<=right){
            int min = (right - left)/2 + left;
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