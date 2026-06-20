class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int count = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                count = Math.max(count, map.get(s.charAt(i)) + 1);
            }
            ans = Math.max(ans, i + 1 - count);
            map.put(s.charAt(i), i);
        }
        return ans;
    }
}