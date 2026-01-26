class Solution {
    /*
    题目：17-电话号码的字母组合     
    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。

    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    */
    private static final String[] MAPPING = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        /*
        思路：对电话号码的每一位数字，依次尝试其对应的所有字母，用DFS枚举所有可能的字母组合，
        通过固定长度的char[] path直接覆盖写入，无需显式回溯。
        */
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }

        List<String> ans = new ArrayList<>();
        char[] path = new char[n];//注意path长度一开始就是n，不是空数组
        dfs(0, ans, path, digits.toCharArray());
        return ans;
    }

    private void dfs(int i, List<String> ans, char[] path, char[] digits) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        String letters = MAPPING[digits[i] - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c;//直接覆盖
            dfs(i + 1, ans, path, digits);
        }
    }
}