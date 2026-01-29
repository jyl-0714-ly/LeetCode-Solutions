class Solution {
    /*
    题目：32.最长有效括号       
    给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号 子串 的长度。

    左右括号匹配，即每个左括号都有对应的右括号将其闭合的字符串是格式正确的，比如 "(()())"。
    */
    public int longestValidParentheses(String s) {
        /*
        思路：通过两次线性扫描（从左到右和从右到左），分别处理括号序列中“右括号过多”和“左括号过多”的情况：
        当左右括号数量相等时更新最长有效长度，一旦右括号数超过左括号（正向）或左括号数超过右括号（反向），
        则重置计数器，从而高效找出最长有效括号子串。
        */
        int n = s.length();
        int ans = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left < right) { // 拆弹器太多了，s[i] 变成红线，重置计数器
                left = right = 0;
            } else if (left == right) { // 完美拆弹
                ans = Math.max(ans, right * 2);
            }
        }

        left = right = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                left++;
            } else {
                right++;
            }
            if (left < right) { // 拆弹器太多了，s[i] 变成红线，重置计数器
                left = right = 0;
            } else if (left == right) { // 完美拆弹
                ans = Math.max(ans, right * 2);
            }
        }
        return ans;
    }
}