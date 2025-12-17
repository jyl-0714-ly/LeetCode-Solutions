class Solution {
    /*
    题目：394.字符串解码    
    给定一个经过编码的字符串，返回它解码后的字符串。

    编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    
    注：你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
        此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
        测试用例保证输出的长度不会超过 105。
    */
    public String decodeString(String s) {
        /*
        思路：辅助栈
        设计两个栈，一个记录字符串，一个记录数字，遍历字符串s，当遇到数字时，将这个字符数字转化为int类型，
        记录到mulri中，当遇到字母时，将字母拼接为字符串先记录到res中，当我们遇到'['时，说明此时该把记录的
        multi和res分别压入数字栈和字符栈，当遇到']'时，说明已经找到了编码字符串最内部的一组编码，此时将数字栈
        最上面的那个数组弹出，就是当前记录的res字符串的重复次数，然后用for循环将其重复完后，那么这一层编码解码完毕，
        此时最内层编码解码后字符串，就和倒数第二内层编码合并，作为新的最内层编码，以此类推，知道全部解码。
        */
        StringBuilder res = new StringBuilder();//记录解码后字符串
        int multi = 0;//记录重复次数
        LinkedList<Integer> stack_multi = new LinkedList<>();//记录重复次数的栈
        LinkedList<String> stack_res = new LinkedList<>();//记录字符串的栈
        for(Character c : s.toCharArray()){
            if(c == '['){//当遇到'['时，说明此时该把记录的multi和res分别压入数字栈和字符栈
                stack_multi.addLast(multi);
                stack_res.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }else if(c == ']'){//当遇到']'时，说明已经找到了编码字符串最内部的一组编码，此时将数字栈弹出，作为当前记录的res字符串的重复次数
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i<cur_multi; i++){//解码
                    tmp.append(res);
                }
                res = new StringBuilder(stack_res.removeLast() + tmp);//记录解码后的字符串
            }else if(c >= '0' && c<='9'){//将字符串中的数字字符转化为int类型，记录到multi中，做为重复次数
                multi = multi*10 + (c - '0');
            }else{//添加普通字母
                res.append(c);
            }
        }
        return res.toString();
    }
}

class Solution {
    /*
    思路：递归
    类似于辅助栈的思想，同样利用res和multi分别记录每段编码前的字符串和重复次数，不过这里的res记录的是解码后的字符串。
    设置全局变量i，来记录遍历到哪一个字符。当遍历到'['时，进入递归，直到进入最内层的编码，将这最内层解码后返回到上一层，
    同时multi置零，当递归结束后，返回res，即可得到答案。
    */
    public String decodeString(String s) {
        return decode(s.toCharArray());
    }
    private int i = 0;//设置i的全局变量，记录处理到了s的哪个字符
    private String decode(char[] s){
        StringBuilder res = new StringBuilder();//记录解码后字符串
        int multi = 0;//记录重复次数
        while(i < s.length){//每个字符处理到后结束
            char c = s[i];
            i++;
            if(Character.isLetter(c)){//添加普通字母
                res.append(c);
            }else if(Character.isDigit(c)){//计算重复次数
                multi = multi*10 + (c - '0');
            }else if(c == '['){//当遇到'['进入递归
                String t = decode(s);
                res.repeat(t,multi);//解码
                multi = 0;//解码完毕后，重复次数置零
            }else{
                break;//当前编码层解码完毕后，结束循环
            }
        }
        return res.toString();//返回当前层和之前层已经解码的字符串
    }
}