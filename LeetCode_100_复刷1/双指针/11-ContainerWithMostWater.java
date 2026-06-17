class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int d = right - left;
            int h = height[left] > height[right] ? height[right] : height[left];
            int s = d * h;
            if(h == height[left]){
                left++;
            }else{
                right--;
            }
            max = Math.max(s, max);
        }
        return max;
    }
}