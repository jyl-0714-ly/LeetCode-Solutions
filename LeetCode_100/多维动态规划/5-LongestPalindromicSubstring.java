class Solution {
    /*
    5.最长回文子串      
    给你一个字符串 s，找到 s 中最长的 回文 子串。
    */
    public String longestPalindrome(String S) {
        /*
        思路：采用中心扩展法求最长回文子串：枚举每个可能的回文中心（包括奇数长度的单字符中心和偶数长度的双字符中心），
        从中心向两边扩展，找到以该中心能延伸出的最长回文串，并不断更新全局最长结果。
        */
        char[] s = S.toCharArray();
        int n = s.length;
        int ansLeft = 0;
        int ansRight = 0;

        // 奇回文串
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
            }
            // 循环结束后，s[l+1] 到 s[r-1] 是回文串
            if (r - l - 1 > ansRight - ansLeft) {
                ansLeft = l + 1;
                ansRight = r; // 左闭右开区间
            }
        }

        // 偶回文串
        for (int i = 0; i < n - 1; i++) {
            int l = i;
            int r = i + 1;
            while (l >= 0 && r < n && s[l] == s[r]) {
                l--;
                r++;
            }
            if (r - l - 1 > ansRight - ansLeft) {
                ansLeft = l + 1;
                ansRight = r; // 左闭右开区间
            }
        }

        return S.substring(ansLeft, ansRight);
    }
}