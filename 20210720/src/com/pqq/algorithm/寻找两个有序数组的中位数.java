package com.pqq.algorithm;

/**
 * @author pqq
 * @create 2021-07-21 11:16
 */
public class 寻找两个有序数组的中位数 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int m = nums1.length;
        int n = nums2.length;

        //分割线在左边的所有元素需要满足的个数m+(n-m+1)/2
        int totalleft = (m + n - 1) / 2;

        //在nums1的区间[0,m]里查找恰当的分割线，
        //使得nums1[i+1]<=nums2[j-1]<=nums1[i]
        int left = 0;
        int right = m;

        while (left < right) {
            int i = left + (right - left) / 2;
            int j = totalleft - i;
            if (nums1[i + 1] > nums2[j]) {
                //下一轮搜索的区间[left,i-1]
                right = i - 1;
            } else {
                //下一轮搜索的区间
                left = i;

            }
        }
        int i = left;
        int j = totalleft - i;
        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if((m+n)%2==1)
        {
            return Math.max(nums1LeftMax,nums2LeftMax);

        }else{
            return (double) ((Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin)))/2;
        }
    }
}
