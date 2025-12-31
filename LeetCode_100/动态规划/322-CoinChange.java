public class Solution {
    /*
    题目：322.零钱兑换  
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
    你可以认为每种硬币的数量是无限的。
    */
    public int coinChange(int[] coins, int amount) {
        /*
        思路：动态规划
        总金额需要最多的硬币的情况是，全部用硬币金额为1来组合，则最大值不超过amount。
        以dp[amount]代表组合硬币个数，则dq[i]为其字问题，递推公式可得：dq[i] = min{dq[i], dq[i-coins]+1};
        根据递推公式，从1~amount开始递推求dq[amount]。
        */
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        // dp[i] 表示凑出金额 i 所需的最少硬币数
        int[] dp = new int[amount + 1];
        
        // 初始化为dp数组为amount + 1
        Arrays.fill(dp, amount + 1);
        dp[0] = 0; // 凑 0 元需要 0 个硬币

        // 自底向上计算 dp[1] ~ dp[amount]
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // 如果 dp[amount] 仍为初始大值，说明无法凑出
        return dp[amount] > amount ? -1 : dp[amount];
    }
}