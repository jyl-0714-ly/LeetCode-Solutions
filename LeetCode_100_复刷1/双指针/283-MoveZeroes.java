class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0, j = 1; j < nums.length; j++){
            if(nums[i] == 0 && nums[j] != 0){
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }else if(nums[i] != 0){
                i++;
            }
        }
    }
}