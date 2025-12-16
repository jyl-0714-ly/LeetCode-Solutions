class MinStack {
    /*
    155.最小栈      
    设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    实现 MinStack 类:
                    MinStack() 初始化堆栈对象。
                    void push(int val) 将元素val推入堆栈。
                    void pop() 删除堆栈顶部的元素。
                    int top() 获取堆栈顶部的元素。
                    int getMin() 获取堆栈中的最小元素。
    */

    /*
    思路：在java中，用peek代表top，为了实现getMin()在O(1)时间复杂度，在往栈中添加元素过程中设计一个辅助栈，
    这个辅助栈每次添加的元素，是上一个元素与本次元素相比的较小值，这样添加后，就可以用getMin()返回最小值了。
    */
    private Deque<Integer> stack;//主栈
    private Deque<Integer> minStack;//辅助栈
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
        //给辅助栈添加一个最大值，给初次对比时，利用Math.min()对比时提供一个最大值
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
        //同步添加，栈正常添加，辅助栈添加最小值
        stack.push(val);
        minStack.push(Math.min(val,minStack.peek()));
    }
    
    public void pop() {
        //同步弹出
        stack.pop();
        minStack.pop();
    }
    
    public int top() {
        //返回栈顶值
        return stack.peek();
    }
    
    public int getMin() {
        //辅助栈的栈顶元素就是最小值，将其返回
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */