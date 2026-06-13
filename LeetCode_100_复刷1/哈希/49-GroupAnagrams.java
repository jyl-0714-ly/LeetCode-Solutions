class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String arr : strs){
            char[] ch = arr.toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);

            List<String> list = map.getOrDefault(s, new ArrayList<>());
            list.add(arr);
            map.put(s, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}