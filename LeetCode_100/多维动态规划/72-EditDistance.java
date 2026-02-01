class Solution {
    /*
    题目：72.编辑距离   
    给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

    你可以对一个单词进行如下三种操作：

    插入一个字符
    删除一个字符
    替换一个字符
    */
    public int minDistance(String text1, String text2) {
        /*
        思路：使用动态规划 + 滚动数组优化，高效求解两个字符串的最小编辑距离（Levenshtein Distance）：
        通过一维数组 f 逐行更新状态，f[j] 表示将 text1 当前前缀转换为 text2 前 j 个字符所需的最少操作数；
        在遍历 text1 的每个字符时，利用 pre 保存左上角状态，根据字符是否相等，选择“保留”或“插入/删除/替换”操作，
        最终 f[m] 即为答案。
        */
        char[] t = text2.toCharArray();
        int m = t.length;
        int[] f = new int[m + 1];
        for (int j = 0; j < m; j++) {
            f[j + 1] = j + 1;
        }
        for (char x : text1.toCharArray()) {
            int pre = f[0];
            f[0]++; // f[0] = i + 1
            for (int j = 0; j < m; j++) {
                int tmp = f[j + 1];
                f[j + 1] = x == t[j] ? pre : Math.min(Math.min(f[j + 1], f[j]), pre) + 1;
                pre = tmp;
            }
        }
        return f[m];
    }
}