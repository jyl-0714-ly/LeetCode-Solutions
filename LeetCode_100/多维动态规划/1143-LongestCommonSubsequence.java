class Solution {
    /*
    题目：1143.最长公共子序列       
    给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。

    一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符
    （也可以不删除任何字符）后组成的新字符串。

    例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
    两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
    */
    public int longestCommonSubsequence(String text1, String text2) {
        /*
        思路：使用滚动数组优化的动态规划求解最长公共子序列（LCS）：通过一维数组 f 从左到右迭代更新，
        pre 变量保存左上角状态，避免使用二维数组高效计算 LCS 长度。
        */
        char[] t = text2.toCharArray();
        int m = t.length;
        int[] f = new int[m + 1];
        for (char x : text1.toCharArray()) {
            int pre = 0; // f[0]
            for (int j = 0; j < m; j++) {
                int tmp = f[j + 1];
                f[j + 1] = x == t[j] ? pre + 1 : Math.max(f[j + 1], f[j]);
                pre = tmp;
            }
        }
        return f[m];
    }
}