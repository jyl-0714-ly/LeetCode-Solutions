class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums.length < 3){
            return list;
        }
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            if(nums[i] + nums[i+1] + nums[i+2] > 0){
                break;
            }
            if(nums[i] + nums[nums.length - 1] + nums[nums.length - 2] < 0){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right + 1]){
                        right--;
                    }
                }else if(nums[i] + nums[left] + nums[right] > 0){
                    right--;
                }else{
                    left++;
                }
            }
        }
        return list;
    }
}