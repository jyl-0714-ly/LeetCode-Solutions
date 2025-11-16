class Solution {
    /*
    题目：238.除自身以外数组的乘积
    给你一个整数数组nums，返回数组answer，其中answer[i]等于nums中除nums[i]之外其余各元素的乘积。

    注：题目数据保证数组nums之中任意元素的全部前缀元素和后缀的乘积都在32位整数范围内。
       请不要使用除法，且在O(n)时间复杂度内完成此题。
    */
    public int[] productExceptSelf(int[] nums) {
    /*
    思路：分析除了自身以外的其他数组元素的乘积，可以看出，除去自身，
    设自身是第i个元素，即所求的是answer[i]：
    i的左边所有元素乘积为L[i]，i的右边所有元素的乘积为R[i]，则answer[i] = L[i]*R[i]。
   
    那么现在就分析怎么求L[i]和R[i]：
    L[i]:因为nums数组第一个元素的左边什么都没有，所以L[0] = 1，
    可以找规律得，L[i] = L[i-1]*nums[i-1]。
    R[i]:因为nums数组最后一个元素的右边什么都没有，所以R[nums.length-1] = 1，
    可以找规律得，R[i] = R[i+1]*nums[i+1]。

    则可求：answer[i] = L[i]*R[i]
    */
        //先初始化创建一些上面思路中需要用到的量，为思路实现代码化做必要准备
        int len = nums.length;
        int[] L = new int[len];
        int[] R = new int[len];
        int[] answer = new int[len];
        
        //因为第一个元素左边什么都没有，所以是1，然后根据分析求每个元素的左边乘积
        L[0] = 1;
        for(int i = 1; i<len; i++){
            L[i] = L[i-1]*nums[i-1];
        }
        
        //因为最后一个元素右边什么都没有，所以是1，然后根据分析求每个元素的左边乘积
        R[len-1] = 1;
        for(int i = len-2; i>=0; i--){
            R[i] = R[i+1]*nums[i+1];
        }

        //得知了第i个元素的左右边的元素乘积，就可以求answer[i]了
        for(int i = 0; i<len; i++){
            answer[i] = L[i]*R[i];
        }
        
        //最后返回answer就可以了
        return answer;
    }
}

//优化空间复杂度
class Solution {    
    public int[] productExceptSelf(int[] nums) {
    /*
    思路：
    直接将answer[i]作为存储L[i]的值，然后再通过一个循环，
    边利用answer[i]的值和R[i]乘，边更新answer[i]的值。
    */
        int[] answer = new int[nums.length];
        
        //answer[i]表示第i个元素的左边所有元素乘积
        answer[0] = 1;
        for(int i = 1; i<nums.length; i++){
            answer[i] = answer[i-1]*nums[i-1];
        }

        //以R表示第i个元素的右边所有元素乘积
        int R = 1;
        for(int i = nums.length-1; i>=0; i--){
 //利用第i个元素左边所有元素的乘积answer[i]，和右边所以元素乘积求，然后再赋值回answer[i]，边用边更新
            answer[i] = answer[i]*R;
 //再每回合更新R的值，和上面联动起来，就省去了L的创立，R也只有一个空间变量
            R = R*nums[i];
        }
        
        return answer;
    }
}