class Solution {
    /*
    题目：79.单词搜索       
    给定一个mxn二维字符网格board和一个字符串单词word。如果word存在于网格中，返回 true ；否则，返回 false 。

    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
    同一个单元格内的字母不允许被重复使用。
    */
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        /*
        思路：该解法通过两次预处理优化（字符频次可行性检查 + 首尾字符频率反转以减少搜索起点），
        再结合 DFS 回溯从每个格子尝试匹配单词：利用原地修改棋盘（置0）标记访问状态，递归探索四个方向，
        匹配失败时恢复现场，确保路径不重复且搜索完整，从而高效判断单词是否存在。
        */

        //为了方便，直接用数组代替哈希表
        int[] cnt = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                cnt[c]++;
            }
        }

        //优化一
        char[] w = word.toCharArray();
        int[] wordCnt = new int[128];
        for (char c : w) {
            if (++wordCnt[c] > cnt[c]) {
                return false;
            }
        }

        //优化二
        if (cnt[w[w.length - 1]] < cnt[w[0]]) {
            w = new StringBuilder(word).reverse().toString().toCharArray();
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, board, w)) {
                    return true;//搜到了！
                }
            }
        }
        return false;//没搜到
    }

    private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
        if (board[i][j] != word[k]) {//匹配失败
            return false;
        }
        if (k == word.length - 1) {//匹配成功！
            return true;
        }
        board[i][j] = 0; //标记访问过
        for (int[] d : DIRS) {
            int x = i + d[0];
            int y = j + d[1]; //相邻格子
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true; //搜到了！
            }
        }
        board[i][j] = word[k]; //恢复现场
        return false; //没搜到
    }
}