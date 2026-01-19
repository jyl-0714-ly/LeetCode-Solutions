class Solution {
    /* 
    题目：62.不同路径   
    一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。

    机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
    问总共有多少条不同的路径？
    */
    public int uniquePaths(int m, int n) {
    /*
    思路：动态规划
    到达(m,n)的上一步可以是，(m-1,n)和(m,n-1)这两种，然后(m-1,n)和(m,n-1)又可以分解为(m-2,n)和(m-1,n-1)，(m,n-2)和(m-1,n-1)
    所以dp[m,n] = dp[m-1,n] + dp[m,n-1]。到最后，dp[0,0] = 1，依据这个倒推得dp[m,n]。
    */
    //使用一维数组，滚动更新
    int[] dp = new int[n];
    //初始化第一行为 1
    Arrays.fill(dp, 1);
    //从第二行开始遍历（i = 1）
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            //dp[j] = 旧 dp[j]+ 新 dp[j-1]
            dp[j] = dp[j] + dp[j - 1];
        }
    }
    return dp[n - 1];
    }
}