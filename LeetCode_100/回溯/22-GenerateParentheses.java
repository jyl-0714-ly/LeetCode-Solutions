class Solution {
    /*
    题目：22.括号生成       
    数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    */
    public List<String> generateParenthesis(int n) {
        /*
        思路：通过DFS递归构造括号序列，用left和right记录已选左右括号数量，在每一步只在合法条件下
        （左括号未用完、右括号少于左括号）选择添加'('或')'，并利用固定长度字符数组直接覆盖写入，无需回溯，
        最终生成所有合法的 n 对括号组合。
        */
        List<String> ans = new ArrayList<>();
        char[] path = new char[n * 2]; //所有括号长度都是一样的2n
        dfs(0, 0, n, path, ans); //一开始没有填括号
        return ans;
    }

    //目前填了left个左括号，right个右括号
    private void dfs(int left, int right, int n, char[] path, List<String> ans) {
        if (right == n) { //填完2n个括号
            ans.add(new String(path));
            return;
        }
        if (left < n) { //可以填左括号
            path[left + right] = '('; //直接覆盖
            dfs(left + 1, right, n, path, ans);
        }
        if (right < left) { //可以填右括号
            path[left + right] = ')'; //直接覆盖
            dfs(left, right + 1, n, path, ans);
        }
    }
}