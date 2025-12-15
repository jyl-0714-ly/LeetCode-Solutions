class Solution {
    /*
    题目：20.有效的括号     
    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串s，判断字符串是否有效。
    有效字符串需满足：
    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    每个右括号都有一个对应的相同类型的左括号。
    */
    public boolean isValid(String s) {
        /*
        思路：栈(先进后出)、哈希表(快速查找)
        如果s长度为奇数就返回false
        先往栈里面依次添加左括号，如果先添加的是右括号，说明肯定不匹配，返回false。
        当添加左括号后，利用哈希表快速查找，如果后面的右括号和栈顶的左括号相匹配的话，则左括号弹出，
        最后只要栈为空，则说明所有左括号全部匹配上了，全部弹出了，则返回true。
        */
        if(s.length() % 2 != 0){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Deque<Character> dq = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)){//如果根据键查不到对应值，说明是左括号
                dq.push(c);//入栈
            }else if(dq.isEmpty() || dq.pop() != map.get(c)){
                //1.如果栈为空，说明先遍历到右括号，所以返回false；
                //2.如果当前的括号c和栈顶括号不匹配，说明不符合条件，所以返回false
                return false;
            }
        }
        return dq.isEmpty();//所有左括号都要匹配完毕
    }
}