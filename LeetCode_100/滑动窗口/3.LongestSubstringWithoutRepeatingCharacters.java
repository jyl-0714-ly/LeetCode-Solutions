class Solution {
    /*
    题目：3.无重复字符的最长子串
    给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。

    注：s由英文字母、数字、符号和空格组成。
    */
    public int lengthOfLongestSubstring(String s) {
        /*
        思路：当我们求一个字符串s的最长子串时，可以思考把他的每一个子串都求出来，
        然后将最大的那个通过Math.max的数学函数求出来，因此，当我们遍历这个字符串的时候，
        就得思考如何求出所有子串，每个子串，就相当于在字符串上连续的一段字符串，
        那么当我们把这个字符串化为数组时，这个子串的长度，就相当于：
        子串的最后一个字符的字符索引(i)-子串第一个字符的字符索引。
        而这个子串，就存在于两个相同的字符的之间，并且包含一个这两个一样的字符。
        因此，我们就可以顺着这个字符串从头到尾的截取每一段子串，并求取其长度，这样就可以得出最长的子串了。
        */
        Map<Character, Integer> map = new HashMap<>();
        if(s.length() == 0){//排除字符串长度为0的情况
            return 0;
        }
        int count = 0;//计算当两个字符相同时，第一个字符的位置对应的字符个数
        int ans = 0;//用来存储最长的子串个数
        for(int i = 0; i<s.length(); i++){//遍历字符串
            if(map.containsKey(s.charAt(i))){//当相同字符存在时，就计算第一个字符对应数组中的字符位置
                count = Math.max(count,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);//当字符不存在，就添加进map
            ans = Math.max(ans,i+1-count);//添加进map同时，也会减去条件里计算的count
        }
        return ans;
    }
}