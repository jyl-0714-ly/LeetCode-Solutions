class Solution {
    /*
    题目：64.最小路径和     64-MinimumPathSum.java
    给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

    说明：每次只能向下或者向右移动一步。
    */
    public int minPathSum(int[][] grid) {
        /*
        思路：采用动态规划，通过维护一个状态转移矩阵f，将到达每个格子的最小路径和分解为“左边格子的最小和”
        与“上边格子的最小和”中的较小值，再加上当前格子的分值，最终从左上角递推计算出到达右下角的全局最优解
        */
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m + 1][n + 1];
        Arrays.fill(f[0], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            f[i + 1][0] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    f[1][1] = grid[i][j];
                } else {
                    f[i + 1][j + 1] = Math.min(f[i + 1][j], f[i][j + 1]) + grid[i][j];
                }
            }
        }
        return f[m][n];
    }
}