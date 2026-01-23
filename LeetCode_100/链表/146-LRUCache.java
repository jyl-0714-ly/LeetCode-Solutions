class LRUCache {
    /*
    146.LRU缓存     146-LRUCache.java
    请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
    LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
    如果不存在，则向缓存中插入该组key-value。如果插入操作导致关键字数量超过capacity,则应该逐出最久未使用的关键字。
    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
    */

    /*
    思路：题意就是capacity：表示最多能缓存的键值对数目；    get：当key存在时，把这个key对应键值对放到最上面，
    反之不存在返回-1；  put：如果该key存在，则把该key原本对应的value换成新value，反之添加到缓存中。
    读懂题意，就容易写出了，难的是不借助函数库，手撕源码来做。
    */
    private final int capacity;
    private final Map<Integer, Integer> cache = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        Integer value = cache.remove(key);
        if(value != null){
            cache.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(cache.remove(key) != null){
            cache.put(key, value);
            return;
        }
        if(cache.size() == capacity){
            Integer eldestKey = cache.keySet().iterator().next();
            cache.remove(eldestKey);
        }
        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */



class LRUCache {
    /*
    思路：我知道要用 HashMap + 双向链表
         get: 查 map，如果存在，把节点移到链表头，返回值
         put: 如果存在，更新值并移头；否则新建节点，插头，超容就删尾
         用 dummy 节点避免边界判断
    */
    private static class Node{
        int key, value;
        Node prev, next;
        Node(int k, int v){
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> keyToNode = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }
    
    public int get(int key) {
        Node node = getNode(key);
        return node != null ? node.value : -1;
    }
    
    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
            return;
        }
        node = new Node(key, value);
        keyToNode.put(key, node);
        pushFront(node);
        if(keyToNode.size() > capacity){
            Node backNode = dummy.prev;
            keyToNode.remove(backNode.key);
            remove(backNode);
        }
    }

    private Node getNode(int key){
        if(!keyToNode.containsKey(key)){
            return null;
        }
        Node node = keyToNode.get(key);
        remove(node);
        pushFront(node);
        return node;
    }

    private void remove(Node x){
        x.prev.next = x.next;
        x.next.prev = x.prev;
    }

    private void pushFront(Node x){
        x.prev = dummy;
        x.next = dummy.next;
        x.prev.next = x;
        x.next.prev = x;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */