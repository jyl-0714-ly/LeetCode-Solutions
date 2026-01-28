class Solution {
    /*
    题目：131.分割回文串    
    给你一个字符串s，请你将s分割成一些子串，使每个子串都是回文串。返回 s 所有可能的分割方案。
    */
    public List<List<String>> partition(String s) {
        /*
        思路：从左到右遍历每个字符，在每个位置决定是否“切一刀”——
        如果当前子串（从上一个切割点 start 到当前位置 i）是回文，就将其加入路径，
        并递归处理剩余部分；
        同时也尝试不切割，继续扩展当前子串。
        当遍历到字符串末尾时，若所有子串均为回文，则将当前分割方案加入结果。
        通过回溯（添加后移除）保证路径状态正确，最终收集所有合法的回文分割方案。
        */
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        dfs(0, 0, s, path, ans);
        return ans;
    }

    //考虑i后面的逗号怎么选
    //start表示当前这段回文子串的开始位置
    private void dfs(int i, int start, String s, List<String> path, List<List<String>> ans) {
        if (i == s.length()) {//s分割完毕
            ans.add(new ArrayList<>(path)); //复制 path
            return;
        }

        // 不分割，不选 i 和 i+1 之间的逗号
        if (i < s.length() - 1) { // i=n-1 时只能分割
            // 考虑 i+1 后面的逗号怎么选
            dfs(i + 1, start, s, path, ans);
        }

        // 分割，选 i 和 i+1 之间的逗号（把 s[i] 作为子串的最后一个字符）
        if (isPalindrome(s, start, i)) {
            path.add(s.substring(start, i + 1));
            // 考虑 i+1 后面的逗号怎么选
            // start=i+1 表示下一个子串从 i+1 开始
            dfs(i + 1, i + 1, s, path, ans);
            path.removeLast(); // path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}