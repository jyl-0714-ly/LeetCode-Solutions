class Solution {
    /*
    题目：300.最长递增子序列        
    给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

    子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
    例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
    */
    public int lengthOfLIS(int[] nums) {
        /*
        思路：动图规划
        要求最长的严格递增子序列，设f[n]为以索引为n的元素的最长严格递增子序列，是nums数组中最长严格递增子序列。
        那么最长严格递增子序列f[n] = Math.max{f[i]}-{i->[0,nums.length]}
        那么我们只需要求出每个f[i]然后对比即可。问题为f[n]，子问题为f[i]。
        由于从0开始在数组里面找的时候，索引每增加1，那么f[i]的大小最多增加1。
        因此f[i] = Math.max{f[i], f[j]+1}-{j->[0,i-1]}
        */
        if(nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp,1);
        for(int i = 0; i<nums.length; i++){
            for(int j = 0; j<i; j++){//求f[i]
                if(nums[i]>nums[j]){//以nums[i]为尾端，求f[i]
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);//对比出最大的f[i]，最后留下的就是f[n]
        }
        return res;
    }
}