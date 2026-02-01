class Solution {
    /*
    题目：84.柱状图中最大的矩形     
    给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

    求在该柱状图中，能够勾勒出来的矩形的最大面积。
    */
    public int largestRectangleArea(int[] heights) {
        /*
        思路：该算法使用单调栈高效求解直方图中最大矩形面积：
        通过两次遍历，分别找出每个柱子左侧第一个更矮的柱子位置（left）和右侧第一个更矮的柱子位置（right），
        从而确定以当前柱子高度为高的最大矩形宽度为 right[i] - left[i] - 1，最终取所有柱子对应矩形面积的最大值。
        */
        int n = heights.length;
        int[] left = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int h = heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= h) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int[] right = new int[n];
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            int h = heights[i];
            while (!st.isEmpty() && heights[st.peek()] >= h) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] - 1));
        }
        return ans;
    }
}