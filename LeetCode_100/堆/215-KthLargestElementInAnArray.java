class Solution {
    /*
    215.数组中的第K个最大元素       
    给定整数数组nums和整数k，请返回数组中第k个最大的元素。

    注：请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
        你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
    */

    /*
    思路：第K个最大元素，就相当于数组排完序后，倒数第K个元素，即排完序后以数组长度n-k为索引的元素。
    随机找一个基准元素，以这个基准元素为准，把所有元素分为大于等于基准元素的和小于等于基准元素的，
    这样划分完毕后，基准元素所处的位置，就是排序后元素的位置，可以与n-k对比：
    如果等于的话，就求出来了；
    如果大于的话，说明n-k索引元素处于小于基准元素的那片元素中，然后进入这片元素，再次这样找；
    如果小于的话，说明n-k索引元素处于大于基准元素的那片元素中，然后进入这片元素，再次这样找；
    最后求出就行。
    */
    private static final Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k;//第k大元素在升序数组中的下标
        int left = 0;
        int right = n - 1;
        while(true){
            //找片段排序后的位置，然后与第k大元素在升序数组中的位置相比
            int i = partition(nums, left, right);
            if(i == targetIndex){
                //刚好相等，找到后返回
                return nums[i];
            }
            if(i > targetIndex){
                //说明位置偏大，应该在[left,i - 1]中
                right = i - 1;
            }else{
                //说明位置偏小，应该在[i + 1,right]中
                left = i + 1;
            }
        }
    }
    private int partition(int[] nums, int left, int right){
        //在第k大元素所处的区域内随机选择的一个基准元素
        int i = left + rand.nextInt(right - left + 1);
        int pivot = nums[i];
        //将pivot元素与区域内首个元素交换位置，避免影响大于pivot的元素和小于pivot元素交换位置
        swap(nums, i, left);
        i = left + 1;
        int j = right;
        //将第k大元素所处的区域内元素按照大于pivot和小于pivot划分为两块
        while(true){
            while(i<=j && nums[i] < pivot)  i++;
            while(i<=j && nums[j] > pivot)  j--;
            if(i>=j)    break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, left, j);//将选定的基准元素归为，彻底划分完毕
        return j;//返回pivot这个基准元素的下标，与所求元素下标对比
    }
    //索引为i，j的nums数组元素，交换位置
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} 