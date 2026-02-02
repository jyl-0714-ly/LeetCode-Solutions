class Solution {
    /*
    题目：200.岛屿数量      
    给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

    岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。

    此外，你可以假设该网格的四条边均被水包围。
    */
    public int numIslands(char[][] grid) {
        /*
        思路：使用深度优先搜索（DFS）遍历二维网格：每当遇到一个未访问的陆地（'1'），就将其视为一个新岛屿，
        计数加一，并通过DFS将该岛屿所有相连的陆地标记为已访问（如改为'2'），防止重复计数；最终返回岛屿总数。
        */
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {//找到了一个新的岛
                    dfs(grid, i, j);//把这个岛插满旗子，这样后面遍历到的'1'一定是新的岛
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j) {
        //出界，或者不是'1'，就不再往下递归
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';//插旗！避免来回横跳无限递归
        dfs(grid, i, j - 1);//往左走
        dfs(grid, i, j + 1);//往右走
        dfs(grid, i - 1, j);//往上走
        dfs(grid, i + 1, j);//往下走
    }
}