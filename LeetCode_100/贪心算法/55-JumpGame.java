class Solution {
    /*
    题目：55.跳跃游戏   
    给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。

    判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
    */
    public boolean canJump(int[] nums) {
        /*
        思路：贪心算法
        由题目得，如果能够依据索引与索引所对应数值从头跳跃到尾，则返回true，反之false。
        设索引为i，那么第i个索引的范围是[i,i+nums[i]]，那么就根据这个范围内的索引，计算范围，如果能越来越大，直到尾部，便是true，
        反之如果出了这个范围，即i索引大于原先索引的范围，那么则返回false。
        */
        int m = 0;
        for(int i = 0; i<nums.length; i++){
            if(i > m){//当还尚未到尾部时，便跳不动了
                return false;
            }
            m = Math.max(m, i + nums[i]);//控制着跳跃的最大边界
        }
        return true;
    }
}