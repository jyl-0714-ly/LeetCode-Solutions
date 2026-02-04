class Solution {
    /*
    题目：4.寻找两个正序数组的中位数            
    给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个
    正序数组的 中位数 。

    算法的时间复杂度应该为 O(log (m+n)) 。
    */
    public double findMedianSortedArrays(int[] a, int[] b) {
        /*
        思路：通过二分查找在较短数组上划分位置，使得两个有序数组被切分为左右两部分，满足左半部分
        所有元素 ≤ 右半部分所有元素；利用循环不变量快速定位正确的分割点，最终根据总长度奇偶性，
        用分割点附近的四个边界值（a[i], a[i+1], b[j], b[j+1]）计算中位数。
        */
        if (a.length > b.length) {
            // 交换 a 和 b
            int[] tmp = a;
            a = b;
            b = tmp;
        }

        int m = a.length;
        int n = b.length;
        // 循环不变量：a[left] <= b[j+1]
        // 循环不变量：a[right] > b[j+1]
        int left = -1;
        int right = m;
        while (left + 1 < right) { // 开区间 (left, right) 不为空
            int i = left + (right - left) / 2;
            int j = (m + n + 1) / 2 - i - 2;
            if (a[i] <= b[j + 1]) {
                left = i; // 缩小二分区间为 (i, right)
            } else {
                right = i; // 缩小二分区间为 (left, i)
            }
        }

        // 此时 left 等于 right-1
        // a[left] <= b[j+1] 且 a[right] > b[j'+1] = b[j]，所以答案是 i=left
        int i = left;
        int j = (m + n + 1) / 2 - i - 2;
        int ai = i >= 0 ? a[i] : Integer.MIN_VALUE;
        int bj = j >= 0 ? b[j] : Integer.MIN_VALUE;
        int ai1 = i + 1 < m ? a[i + 1] : Integer.MAX_VALUE;
        int bj1 = j + 1 < n ? b[j + 1] : Integer.MAX_VALUE;
        int max1 = Math.max(ai, bj);
        int min2 = Math.min(ai1, bj1);
        return (m + n) % 2 > 0 ? max1 : (max1 + min2) / 2.0;
    }
}