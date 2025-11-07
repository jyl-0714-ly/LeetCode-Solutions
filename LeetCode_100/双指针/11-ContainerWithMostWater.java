class Solution {
    /*
    题目：11.盛最多水的容器
    给定一个长度为n的整数数组height。有n条垂线，第i条线的两个端点是(i, 0)和(i, height[i])。
    找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。返回容器可以储存的最大水量。

    注：你不能倾斜容器。
    */
    public int maxArea(int[] height) {
        /*
        思路：本题实则求的是面积，对于面积，要关注其底和高，要求最大面积，那么底和高一定要尽量大，
        因此需要用到双指针，一个在最左边(left)，一个在最右边(right)。
        分别分析底和高：
        高：因为是盛水，所以需要考虑短板，且数组数据是随机给的，并无规则。
           所以高是left、right指向的更小的那一个数组元素。
        底：用双指针，一个在left = 0，一个在 a = right = height.length-1，此时底最大。
           随着指针移动，底的变化是有规律的，与指针移动规律有关（指针移动多少，底就减少多少）。

        分析过后：
        底，有一定变化规律的，容易得出变化规律。即right - left。
        高，需要考虑的是，高需要尽可能高，才能使面积尽可能大，那么就要舍弃较小的高，
        因此 b = height[left] > height[right] ? height[right] : height[left]。

        得到底和高那么可得面积 s = a * b，因为面积(s)是由底(a)和高(b)组合相乘而得。 
        那么为了求最大值，通过一个数学函数Math.max()，可以使在指针遍历数组后，所能够留下来s最大。
        */
        int left = 0;//定义左指针
        int right = height.length - 1;//定义右指针
        int ans = 0;//存储s的最大值
        while (right > left) {//遍历数组，当遍历一遍之后，停止循环
            int a = right - left;//求底
            int b = height[left] > height[right] ? height[right] : height[left];//因为是盛水，故选出小的那个
            int s = a * b;//得到底和高后，相乘即面积
            ans = Math.max(ans, s);//每次指针移动后，所求的最大的面积(s)，存储到ans里面，循环结束后的ans，即最大值
            if (height[left] > height[right]) {//在本轮循环中，两个高之中，小的那个短板舍弃，换下一个，因此--、++
                right--;
            } else {
                left++;
            }
        }
        return ans;//返回最大面积
    }
}
