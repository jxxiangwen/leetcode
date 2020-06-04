package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author jxxiangwen
 * Mail: xiangwen.zou@ymm56.com
 * Time: 20-6-4 下午10:30
 */
public class FindMin_153 {
    public int findMin(int[] nums) {
        if (null == nums || 0 == nums.length) {
            throw new IllegalArgumentException();
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        // 只有逆序才存在最小值
        while (nums[left] >= nums[right]) {
            if (right - left == 1) {
                mid = right;
                break;
            }
            mid = (left + right) >> 1;
            // 左边有序,就找右边
            if (nums[left] <= nums[mid]) {
                left = mid;
            } else {
                // 右边有序,就找左边
                right = mid;
            }
        }
        return nums[mid];
    }

    @Test
    public void testFindMin() {
        int[] example = new int[]{4, 5, 6, 7, 0, 1, 2};
        Assert.assertEquals(findMin(example), 0);
        example = new int[]{1};
        Assert.assertEquals(findMin(example), 1);
        example = new int[]{5, 1, 2, 3, 4};
        Assert.assertEquals(findMin(example), 1);
    }
}
