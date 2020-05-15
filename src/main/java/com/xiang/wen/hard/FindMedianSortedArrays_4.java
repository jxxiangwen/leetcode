package com.xiang.wen.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-5-14 上午10:04
 * <p>
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class FindMedianSortedArrays_4 {

    /**
     * 时间复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        int[] merge = new int[num1Length + num2Length];
        int search1 = 0;
        int search2 = 0;
        int index = 0;
        while (search1 < num1Length && search2 < num2Length) {
            if (nums1[search1] < nums2[search2]) {
                merge[index] = nums1[search1];
                search1++;
                index++;
            } else {
                merge[index] = nums2[search2];
                search2++;
                index++;
            }
        }
        while (search1 < num1Length) {
            merge[index] = nums1[search1];
            search1++;
            index++;
        }
        while (search2 < num2Length) {
            merge[index] = nums2[search2];
            search2++;
            index++;
        }
        if (merge.length % 2 == 0) {
            return (merge[merge.length / 2 - 1] + merge[merge.length / 2]) / 2.0;
        } else {
            return merge[merge.length / 2];
        }
    }

    /**
     * 时间复杂度O(log(m + n))
     * 看到题目要求log复杂度，基本就是二分查找或者二分查找的变种
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArraysByFindKth(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
    }

    private double findKth(int[] nums1, int i, int[] nums2, int j, int k) {
        if (i >= nums1.length) {
            return nums2[j + k - 1];
        }
        if (j == nums2.length) {
            return nums1[i + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[i], nums2[j]);
        }
        int k1 = i + k / 2 - 1 >= nums1.length ? Integer.MAX_VALUE : nums1[i + k / 2 - 1];
        int k2 = j + k / 2 - 1 >= nums2.length ? Integer.MAX_VALUE : nums2[j + k / 2 - 1];

        if (k1 < k2) {
            return findKth(nums1, i + k / 2, nums2, j, k - k / 2);
        } else {
            return findKth(nums1, i, nums2, j + k / 2, k - k / 2);
        }
    }

    @Test
    public void testFindMedianSortedArrays() {
        int[] num1 = new int[]{1, 3};
        int[] num2 = new int[]{2};
        Assert.assertEquals(findMedianSortedArrays(num1, num2), 2.0d, 0.01);
        Assert.assertEquals(findMedianSortedArraysByFindKth(num1, num2), 2.0d, 0.01);
        num1 = new int[]{1, 2};
        num2 = new int[]{3, 4};
        Assert.assertEquals(findMedianSortedArrays(num1, num2), 2.5d, 0.01);
        Assert.assertEquals(findMedianSortedArraysByFindKth(num1, num2), 2.5d, 0.01);
        num1 = new int[]{1};
        num2 = new int[]{2, 3, 4, 5, 6};
        Assert.assertEquals(findMedianSortedArrays(num1, num2), 3.5d, 0.01);
        Assert.assertEquals(findMedianSortedArraysByFindKth(num1, num2), 3.5d, 0.01);
    }
}
