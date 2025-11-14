class Solution {
    /*
    题目：53.最大子数组和
    给你一个整数数组nums，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

    注：子数组是数组中的一个连续部分。
    */
    public int maxSubArray(int[] nums) {
    /*
    思路：动态规划
    能够知道，所求的子数组，一定是以nums数组中的某一个元素为结尾，假设这个数为nums[i]，
    因为这个子数组的和，一定是由一个以nums[i-1]为结尾，并且大于零的一个子数组的和，设这个和为tns[i-1]，
    则总的最大值为：tns[i] = tns[i-1] + nums[i]。
    分析tns[i-1]：
    ①大于0：继续向下加，并不断将这个值结合下一个值nums[i]，计算tns[i]，将tns[i]暂时存储在tns中。
    ②小于0：则以tns[i]为起点，重新找下一段能够大于0的子数组。
    */
        int ans = 0;
        int tns = nums[0];
        for(int num : nums){//遍历数组
            ans = Math.max(ans + num, num);//不断求出临时最大的tns[i-1]，并与nums[i]相加，得到tns[i]
            tns = Math.max(tns, ans);//将临时最大的tns[i]存储到tns中，然后撑到最后的就是最大的
        }
        return tns;
    }
}