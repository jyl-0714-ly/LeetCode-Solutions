class Trie {
    /*
    题目：208.实现Trie（前缀树）    
    Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。
    这一数据结构有相当多的应用情景，例如自动补全和拼写检查。

    请你实现 Trie 类：

    Trie() 初始化前缀树对象。
    void insert(String word) 向前缀树中插入字符串 word 。
    boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，
    返回 false 。
    boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；
    否则，返回 false 。
    */

    /*
    思路：实现了一个字典树（Trie），通过 insert 将单词逐字符插入树中，每个节点包含 26 个子节点（对应小写字母）
    和一个标志位 end 表示是否为单词结尾；search 和 startsWith 均调用辅助方法 find：若路径不存在返回 0，
    路径存在但非完整单词返回 1，完全匹配单词则返回 2，从而高效支持精确查找与前缀匹配。
    */

    private static class Node {
        Node[] son = new Node[26];
        boolean end = false;
    }

    private final Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) { // 无路可走？
                cur.son[c] = new Node(); // new 出来！
            }
            cur = cur.son[c];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return find(word) == 2;
    }

    public boolean startsWith(String prefix) {
        return find(prefix) != 0;
    }

    private int find(String word) {
        Node cur = root;
        for (char c : word.toCharArray()) {
            c -= 'a';
            if (cur.son[c] == null) { // 道不同，不相为谋
                return 0;
            }
            cur = cur.son[c];
        }
        // 走过同样的路（2=完全匹配，1=前缀匹配）
        return cur.end ? 2 : 1;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */