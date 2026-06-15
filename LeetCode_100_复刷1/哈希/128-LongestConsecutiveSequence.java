class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            st.add(num);
        }
        int m = st.size();

        int ans = 0;
        for (int x : st) {
            if (st.contains(x - 1)) {
                continue;
            }
            int y = x + 1;
            while (st.contains(y)) {
                y++;
            }
            ans = Math.max(ans, y - x);
            if (ans * 2 >= m) {
                break;
            }
        }
        return ans;
    }
}