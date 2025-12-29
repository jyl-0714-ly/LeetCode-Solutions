class Solution {
    /*
    198.打家劫舍        
    你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

    给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
    */
    public int rob(int[] nums) {
        /*
        思路：动态规划
        此题关键在于求出子问题的递推关系，当有k间房子时，求其最大值f(k)，当我们在第k间房子为主视角，
        分为两种情况：
                    1.偷了第k间房子，则k-1间不能偷，f(k)=f(k-2)+nums[k-1];
                    2.不偷第k间房子，则k-1间必须偷，f(k)=f(k-1);
        所以f(k)=max{f(k−1),f(k−2)+nums[k−1]}，根据此递推公式，可以求解。
        */
        int curr = 0;
        int prev = 0;
        for(int i : nums){
            //curr表示f(k-1)，prew表示f(k-2)，i表示nums[k-1]。
            int temp = Math.max(curr, i + prev);
            //随着i的索引每递增1，curr-f(k-1)，就会变为prev-f(k-2)，
            prev = curr;
            //而因为curr=f(k-1)，所以curr又变为max(curr, i + prev)得出的最大值
            curr = temp;
        }
        return curr;
    }
}