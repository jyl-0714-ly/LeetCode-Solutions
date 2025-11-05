class Solution {
    /*
    题目：49.字母异位词分组
    给你一个字符串数组，请你将字母异位词组合在一起。

    注：字母异位词是通过重新排列不同单词或短语的字母而形成的单词或短语，并使用所有原字母一次。
        可以按任意顺序返回结果列表。
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        思路：由于字母异位词之间的字母组成是一样的，
        因此将两个互为字母异位词的字符串转化为字符后排序，再转化为字符串，这两个字符串一样。
        因而再将排完序后转化为字符串的字符串作为哈希表的键，那么对于的值放到List集合里面，就可以满足题目的返回值。
        最后将值转换为List集合，即可求出最终结果。
        */
        Map<String, List<String>> map = new HashMap<>();
        for(String arr : strs){//迭代遍历数组，挨个添加
            char[] ch = arr.toCharArray();//将数组的字符串元素，转换为字符数组
            Arrays.sort(ch);//将字符数组排序
            String k = new String(ch);//排完序后再转回字符串
            //把排序后的字符串k作为键：
            //如果map中存在当前k（即已有该字母异位词的分组），则直接获取已存在的List（不会新建）。
            //如果map中不存在当前k（即该字母异位词是第一次出现），则创建一个新的ArrayList。
            List<String> list = map.getOrDefault(k, new ArrayList<String>());
            list.add(arr);//将本轮迭代的字符串，添加到List集合中
            map.put(k, list);//将对于键值对添加到Map集合中
        }
        return new ArrayList<List<String>>(map.values());//获得Map集合中的值，并转换为List集合，满足题目要求
    }
}