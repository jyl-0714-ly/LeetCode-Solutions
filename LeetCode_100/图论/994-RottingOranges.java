class Solution {
    /*
    994.腐烂的橘子      
    在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：

    值 0 代表空单元格；
    值 1 代表新鲜橘子；
    值 2 代表腐烂的橘子。
    每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。

    返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
    */
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 四方向

    public int orangesRotting(int[][] grid) {
        /*
        思路：使用多源广度优先搜索（BFS）模拟腐烂橘子的扩散过程：首先统计所有新鲜橘子数量，并将初始所有腐烂橘子
        加入队列；每分钟，当前所有腐烂橘子同时向上下左右四个方向感染相邻的新鲜橘子，被感染的橘子变为腐烂并加入
        下一轮队列；若最终仍有新鲜橘子剩余，说明无法全部腐烂，返回-1；否则返回所需分钟数。
        */
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        List<int[]> q = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    fresh++;//统计新鲜橘子个数
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});//一开始就腐烂的橘子
                }
            }
        }

        int ans = 0;
        while (fresh > 0 && !q.isEmpty()) {
            ans++;//经过一分钟
            List<int[]> tmp = q;
            q = new ArrayList<>();
            for (int[] pos : tmp) {//已经腐烂的橘子
                for (int[] d : DIRECTIONS) {//四方向
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];
                    if (0 <= i && i < m && 0 <= j && j < n && grid[i][j] == 1) {//新鲜橘子
                        fresh--;
                        grid[i][j] = 2;//变成腐烂橘子
                        q.add(new int[]{i, j});
                    }
                }
            }
        }

        return fresh > 0 ? -1 : ans;
    }
}